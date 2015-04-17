package CucumberTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Created by Student on 4/15/2015.
 */
public class StartPage {
    private WebDriver driver;
    private String baseURL = "http://www.yandex.ua/";

    public ResultsPage sendSearchRequest(String inputString){
        driver.findElement(By.xpath(".//*[@id='text']")).clear();
        driver.findElement(By.xpath(".//*[@id='text']")).sendKeys(inputString + Keys.RETURN);
        return new ResultsPage(this.driver);
    }

    public void open(){
        driver.get(baseURL);
    }

    public StartPage(WebDriver driver){
        this.driver = driver;
    }
}
