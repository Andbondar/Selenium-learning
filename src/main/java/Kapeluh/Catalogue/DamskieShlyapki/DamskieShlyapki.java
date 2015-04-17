package Kapeluh.Catalogue.DamskieShlyapki;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bondar on 4/17/2015.
 */
public class DamskieShlyapki {
    private WebDriver driver;
    private List<TeaserItem> teaserItems;

    public DamskieShlyapki(WebDriver driver){
        this.driver = driver;
    }

    public List<TeaserItem> getTeaserItems(){
        List<TeaserItem> returnedList  = new ArrayList<>();
        List<WebElement> webElementList =  driver.findElements(By.xpath(".//*[@class=\"teaser-item\"]"));
        for (WebElement webElement : webElementList){
            returnedList.add(new TeaserItem(driver, webElement));
        }
        return returnedList;
    }

    public void checkTeaserItems(){
        this.teaserItems = getTeaserItems();
        for (TeaserItem teaserItem : teaserItems){
            teaserItem.checkStructure();
        }
    }


}
