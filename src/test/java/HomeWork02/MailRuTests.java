package HomeWork02;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static InputProcessing.XMLParser.getInfoByTag;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by bondar on 4/14/2015.
 */
public class MailRuTests {
    private WebDriver driver;
    private String baseURL;
    String login = String.valueOf(getInfoByTag("D:\\mailru_user.txt", "login").get(0));
    String password = String.valueOf(getInfoByTag("D:\\mailru_user.txt", "pass").get(0));

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

        //login
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).sendKeys(login);
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='mailbox__auth__button']")).click();

        //check that user is logged in
        String loggedEmail = driver.findElement(By.xpath(".//*[@id='PH_user-email']")).getText();
        assertEquals("Wrong user is logged in", loggedEmail, login + "@mail.ru");
        //"write letter" button
        driver.findElement(By.xpath(".//*[@id='b-toolbar__left']//a")).click();
        //check that page is changed and new one is a page for letter writing
        assertTrue(driver.getCurrentUrl().matches("compose"));
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).clear();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).click();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).sendKeys(login + "@mail.ru");//error here
        driver.findElement(By.xpath(".//input[@name=\"Subject\"]")).sendKeys("Test letter");
        //text
        driver.findElement(By.xpath(".//*[@id='tinymce']")).clear();
        driver.findElement(By.xpath(".//*[@id='tinymce']")).sendKeys("Test send keys");

    }
}
