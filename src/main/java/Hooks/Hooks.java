package Hooks;

import ObjectRepo.ObjectRepo;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {



    @Before
    public void setUpDriver() throws Exception{
        //ChromeDriver driver = new ChromeDriver();
        ObjectRepo.driver = new ChromeDriver();
        ObjectRepo.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        ObjectRepo.driver.manage().timeouts().pageLoadTimeout(240, TimeUnit.SECONDS);
        ObjectRepo.driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception{
        ObjectRepo.driver.quit();
    }
}
