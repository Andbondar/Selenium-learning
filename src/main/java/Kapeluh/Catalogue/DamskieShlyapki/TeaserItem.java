package Kapeluh.Catalogue.DamskieShlyapki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by bondar on 4/17/2015.
 */
public class TeaserItem {
    private WebDriver driver;
    private WebElement container;

    public TeaserItem(WebDriver driver, WebElement container){
        this.driver = driver;
        this.container = container;
    }
    //Check that elements contains picture, Link with name, Star rating, Price, 'Details' link
    public void checkStructure(){
        //check that image is present
        assertTrue("Picture is absent", driver.findElements(By.xpath(".//img")).size() == 1);
        //check that exactlty one 'Details' link is present
        assertTrue("Number of Details links != 1", driver.findElements(By.xpath(".//p//a[contains(@href, \"item\")]")).size() == 1);

    }
}
