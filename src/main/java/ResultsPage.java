import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Student on 4/15/2015.
 */
public class ResultsPage {
    private WebDriver driver;
    public ResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ResultsPage sendSearchRequest(String inputString){
        driver.findElement(By.xpath(".//*[@class=\"input__control\" and @type=\"search\"]")).clear();
        driver.findElement(By.xpath(".//*[@class=\"input__control\" and @type=\"search\"]")).sendKeys(inputString + Keys.RETURN);
        return new ResultsPage(this.driver);
    }

    protected List<ResultItem> resultList(){
        List<ResultItem> returnedList = new ArrayList<>();
        List<WebElement> webElementsList = driver.findElements(By.xpath(".//*[@class=\"serp-item__wrap clearfix\" and descendant::h2]"));
        for (WebElement element: webElementsList){
            returnedList.add(new ResultItem(driver, element));
        }
        return returnedList;
    }

}
