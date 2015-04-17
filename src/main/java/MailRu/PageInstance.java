package MailRu;

import MailRu.EmailPage.EmailPage;
import MailRu.EmailPage.WriteLetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by bondar on 4/17/2015.
 */
public class PageInstance {
    protected WebDriver driver;
    protected String baseURL;
    protected StartPage startPage;
    protected EmailPage emailPage;
    protected WriteLetter writeLetter;

    public void setBrowser(String browser){
        File file;
        switch (browser.toLowerCase()){
            case "ie":
                file = new File("tools/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                break;
            case "ch":
                file = new File("tools/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case "ff":
            default:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
}
