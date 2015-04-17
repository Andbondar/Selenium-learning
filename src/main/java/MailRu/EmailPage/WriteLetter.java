package MailRu.EmailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by bondar on 4/17/2015.
 */
public class WriteLetter {
    private WebDriver driver;

    public WriteLetter(WebDriver driver){
        this.driver = driver;
    }

    public void addReceiver(String email){
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).clear();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).click();
        driver.findElement(By.xpath(".//textarea[@data-original-name=\"To\"]")).sendKeys(email + Keys.RETURN);
    }

    public void addSubject(String subject){
        driver.findElement(By.xpath(".//input[@name=\"Subject\"]")).sendKeys(subject);
    }

    public void addText(String textMessage){
        if (driver instanceof JavascriptExecutor) {
            ((JavascriptExecutor) driver).executeScript("window.parent.tinyMCE.activeEditor.setContent('" + textMessage + "');");
        }
    }

    public EmailPage sendLetter(){
        driver.findElement(By.xpath(".//*[@data-name=\"send\"]")).click();
        driver.findElement(By.xpath(".//a[@class=\"b-nav__link\" and @href=\"/messages/inbox/\"]")).click();
        //wait till new page is opened. This sleep is also needed to ensure that letter is sent
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new EmailPage(driver);
    }
}
