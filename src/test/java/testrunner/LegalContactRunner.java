package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepdefinition.LoginStep;

@CucumberOptions(features = { "classpath:LegalContact.feature" },
        glue = { "stepdefinition", "Hooks"},
        plugin = { "pretty",
                "json:target/LoginRunner.json" })
public class LegalContactRunner extends AbstractTestNGCucumberTests {
}