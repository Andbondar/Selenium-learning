package CucumberTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Student on 4/17/2015.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue = {"CucumberTests"},
        format = {"pretty", "html:Folder_Name"},
        tags = { "@Test" }
)


public class Test_001 extends PageInstance {

    @BeforeClass
    public static void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @After
    public static void tearDownAfterEach(){
        driver.close();
    }
}
