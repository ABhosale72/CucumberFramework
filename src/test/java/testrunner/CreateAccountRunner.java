package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:CreateAccount.feature" },
        glue = { "stepdefinition", "Hooks"},
        plugin = { "pretty",
                "json:target/CreateAccountRunner.json" })
public class CreateAccountRunner extends AbstractTestNGCucumberTests {
}