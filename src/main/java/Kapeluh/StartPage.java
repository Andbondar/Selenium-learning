package Kapeluh;

import Kapeluh.Catalogue.CataloguePage;
import org.openqa.selenium.WebDriver;

/**
 * Created by bondar on 4/17/2015.
 */
public class StartPage {
    private WebDriver driver;
    private String baseURL = "http://kapeluh.com.ua/";

    public StartPage(WebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get(baseURL);
    }
    public CataloguePage openCatalogue(){
        driver.get(baseURL + "frontpage/produktsiya");
        return new CataloguePage(driver);
    }
}
