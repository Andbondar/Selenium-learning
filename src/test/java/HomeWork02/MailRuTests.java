package HomeWork02;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static InputProcessing.TextParser.getTextFromTXTFile;
import static InputProcessing.XMLParser.getInfoByTag;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by bondar on 4/14/2015.
 */
public class MailRuTests {
    private WebDriver driver;
    private String baseURL;
    String login = String.valueOf(getInfoByTag("D:\\config_mailru.xml", "login").get(0));
    String password = String.valueOf(getInfoByTag("D:\\config_mailru.xml", "pass").get(0));

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseURL = "https://mail.ru/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void SendReceiveEmail() {
        driver.get(baseURL);
        driver.manage().window().maximize();
        //text for our letter
        String textMessage = "";
        try{
            textMessage = getTextFromTXTFile("D:\\read.txt");
        } catch (IOException e){
            e.printStackTrace();
        }
        //combine all the text into solid string
        textMessage = textMessage.replace("\n", "<br>").replace("\r", "<br>").replace("<br><br>", "<br>");

        //login
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).sendKeys(login);
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='mailbox__auth__button']")).click();

        //check that user is logged in
        String loggedEmail = driver.findElement(By.xpath(".//*[@id='PH_user-email']")).getText();
        assertEquals("Wrong user is logged in", loggedEmail, login + "@mail.ru");
        int initialLetterCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@class=\"b-nav__item__count\"]")).getText());
        //"write letter" button
        driver.findElement(By.xpath(".//*[@id='b-toolbar__left']//a")).click();
        //check that page is changed and new one is a page for letter writing
        assertTrue("Page is not changed", driver.getCurrentUrl().matches(".*compose.*"));
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).clear();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).click();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).sendKeys(login + "@mail.ru" + Keys.RETURN);

        String subject = "Test letter";
        driver.findElement(By.xpath(".//input[@name=\"Subject\"]")).sendKeys(subject);
        //text
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.parent.tinyMCE.activeEditor.setContent('" + textMessage + "');");
        }
        //send letter
        driver.findElement(By.xpath(".//*[@data-name=\"send\"]")).click();
        driver.findElement(By.xpath(".//a[@class=\"b-nav__link\" and @href=\"/messages/inbox/\"]")).click();
        //check that correct page is opened (inbox)
        assertTrue("Page is not changed", driver.getCurrentUrl().matches(".*inbox.*"));
        int updatedLetterCount = Integer.parseInt(driver.findElement(By.xpath(".//*[@class=\"b-nav__item__count\"]")).getText());
        //check that new email is received by current count of unread emails
        assertTrue("No new letters", updatedLetterCount > initialLetterCount);
        //Open this letter
        driver.findElement(By.xpath("(.//*[@class=\"b-datalist__body\"]//a[@data-subject='" + subject + "'])[1]")).click();//we search latest letter with this theme

        //check that this letter is sent today - update for regex with russian characters needed
        //boolean flag = driver.findElement(By.xpath(".//*[@class=\"b-letter__head__date\"]")).getText().matches(".*Сегодня.*");
        //assertTrue("Letter was not sent today", flag);

        //check for text in received letter can be added
    }
}
