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
    //Check that elements contains picture, Link with name, Star rating, Price, 'Details' link. Checks are performed via search inside container element by xPath.
    public void checkStructure(){ //this method should be divided into smaller ones if independent checks would be needed
        //check that image is present
        assertTrue("Picture is absent", container.findElements(By.xpath(".//img")).size() != 0);
        //check that link with name is present
        assertTrue("Exactly one link with name not found", container.findElements(By.xpath(".//*[@class=\"element element-itemname first\"]//a")).size() == 1);
        //check that stars are present
        assertTrue("Star rating is absent", container.findElements(By.xpath(".//*[@class=\"rating-container star5\"]")).size() != 0);
        //check that price is present
        assertTrue("Price is absent", container.findElements(By.xpath(".//*[@class=\"element element-textarea last\"]//h3")).size() != 0);
        //check that exactlty one 'Details' link is present
        assertTrue("Exactly one Details link not found", container.findElements(By.xpath(".//p//a[contains(@href, \"item\")]")).size() == 1);
    }
}
