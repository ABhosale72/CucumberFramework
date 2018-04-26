package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepdefinition.LoginStep;

@CucumberOptions(features = { "classpath:CommercePage.feature" },
        glue = { "stepdefinition", "Hooks"},
        plugin = { "pretty",
                "json:target/LoginRunner.json" })
public class CommercePageRunner extends AbstractTestNGCucumberTests {
}