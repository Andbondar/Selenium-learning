package HomeWork02;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bondar on 4/14/2015.
 */
public class MailRuTests {
    private WebDriver driver;
    private String baseURL;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseURL = "https://mail.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCategoryList() {
        driver.get(baseURL);
        driver.manage().window().maximize();


    }
}
