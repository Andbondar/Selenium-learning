import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Student on 4/10/2015.
 */
public class Test01 extends PageInstance {
    private WebDriver driver;
    private String baseURL;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseURL = "http://ya.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testYaRu(){
        driver.get(baseURL);
        driver.manage().window().maximize();

        boolean flag = driver.findElement(By.xpath("//*")).isDisplayed();
        Assert.assertTrue("test message", flag);

        driver.findElement(By.xpath(".//*[@id='text']")).sendKeys("Test search");
        driver.findElement(By.xpath("//*[@type=\"submit\"]")).click();
    }
}
