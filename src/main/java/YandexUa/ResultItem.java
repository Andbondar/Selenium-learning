package YandexUa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Student on 4/15/2015.
 */
public class ResultItem {
    WebDriver driver;
    WebElement container;

    public ResultItem(WebDriver driver, WebElement container){
        this.driver = driver;
        this.container = container;
    }

    public void setContainer(){
        this.container = container;
    }

    public WebElement getLink(){
        return driver.findElement(By.xpath(".//h2/a"));
    }
}
