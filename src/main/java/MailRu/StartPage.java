package MailRu;

import MailRu.EmailPage.EmailPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.Assert.assertEquals;

/**
 * Created by bondar on 4/17/2015.
 */
public class StartPage {
    protected WebDriver driver;
    protected String baseURL = "https://mail.ru/";

    public StartPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(baseURL);
    }

    public EmailPage loginToMail(String login, String password){
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__login']")).sendKeys(login);
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).clear();
        driver.findElement(By.xpath(".//*[@id='mailbox__password']")).sendKeys(password);
        driver.findElement(By.xpath(".//*[@id='mailbox__auth__button']")).click();
        //check that correct user is logged in
        String loggedEmail = driver.findElement(By.xpath(".//*[@id='PH_user-email']")).getText();
        assertEquals("Wrong user is logged in", loggedEmail, login + "@mail.ru");

        return new EmailPage(driver);
    }
}
