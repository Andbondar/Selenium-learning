import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by Student on 4/10/2015.
 */
public class Test01 extends PageInstance {
    private WebDriver driver;
    private String baseURL;

    @Before
    public void setUp(){
        setChDriver();
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

    public void setFFDriver(){
        this.driver = new FirefoxDriver();
    }
    public void setIEDriver(){
        File file = new File("tools/IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        driver = new InternetExplorerDriver();
    }
    public void setChDriver(){
        File file = new File("tools/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        driver = new ChromeDriver();
    }
}
