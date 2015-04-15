import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Student on 4/15/2015.
 */
public class ResultContainer {
    WebDriver driver;
    WebElement container;

    public ResultContainer(WebDriver driver){
        this.driver = driver;
    }
    public void setContainer(){
        this.container = container;
    }

    public WebElement getLink(){
        return driver.findElement(By.xpath("(.//a)[1]"));
    }
}
