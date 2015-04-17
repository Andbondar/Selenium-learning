package MailRu.EmailPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by bondar on 4/17/2015.
 */
public class EmailPage {
    private WebDriver driver;

    public EmailPage(WebDriver driver){
        this.driver = driver;
    }

    public WriteLetter writeLetter(){
        //"write letter" button
        driver.findElement(By.xpath(".//*[@id='b-toolbar__left']//a")).click();
        return new WriteLetter(driver);
    }

    public int getCurrentUnreadCount(){
        return Integer.parseInt(driver.findElement(By.xpath(".//*[@class=\"b-nav__item__count\"]")).getText());
    }
}
