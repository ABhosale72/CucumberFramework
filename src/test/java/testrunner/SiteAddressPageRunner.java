package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:SiteAddressPage.feature" },
        glue = { "stepdefinition", "Hooks"},
        plugin = { "pretty",
                "json:target/LoginRunner.json" })
public class SiteAddressPageRunner extends AbstractTestNGCucumberTests {
}