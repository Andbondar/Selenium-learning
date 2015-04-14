package HomeWork02;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by bondar on 4/14/2015.
 */
public class KapeluhTests {
    private WebDriver driver;
    private String baseURL;

    @Before
    public void setUp(){
        driver = new FirefoxDriver();
        baseURL = "http://kapeluh.com.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void verifyCategoryList(){
        driver.get(baseURL);
        driver.manage().window().maximize();
        boolean flag;

        int numberOfCategories = driver.findElements(By.xpath("//a[contains(@href,'category')]")).size();
        //String[] array of categories on the start page
        ArrayList<String> categoriesArray = new ArrayList<String>();
        //i - number of match for xPath
        for (int i = 1; i <= numberOfCategories; i++){
            categoriesArray.add(driver.findElement(By.xpath("(//a[contains(@href,'category')])[" + i + "]")).getText());
        }
        System.out.println("List of categories on Start page:");
        System.out.println(categoriesArray);

        //open Catalogue
        driver.get("http://kapeluh.com.ua/frontpage/produktsiya");
        int numberOfCategoriesCatalogue = driver.findElements(By.xpath(".//div[@class = 'category']//a[contains(@href,'category')]")).size();
        ArrayList<String> categoriesArrayCatalogue = new ArrayList<String>();
        //i - number of match for xPath
        for (int i = 1; i <= numberOfCategoriesCatalogue; i++){
            categoriesArrayCatalogue.add(driver.findElement(By.xpath("(//a[contains(@href,'category')])[" + i + "]")).getText());
        }
        System.out.println("List of categories on Catalogue page:");
        System.out.println(categoriesArrayCatalogue);

        flag = categoriesArrayCatalogue.equals(categoriesArray);
        assertTrue("Lists of categories on Start page and on Catalogue page are not equal", flag);
        //print difference to console
        for (int i = 1; i < numberOfCategoriesCatalogue; i++){
            if (!(categoriesArrayCatalogue.get(i).equals(categoriesArray.get(i)))){
                System.out.println("Element " + categoriesArrayCatalogue.get(i) + "(#" + i + ") is not equal to element from source category list " + categoriesArray.get(i));
                System.out.println("First difference returned");
                break;
            }
        }
    }
}
