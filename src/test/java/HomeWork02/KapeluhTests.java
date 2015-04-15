package HomeWork02;

import Checks.CompareArrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
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

        int numberOfCategories = driver.findElements(By.xpath("//a[contains(@href,'category')]")).size();
        //ArrayList of categories on the start page
        List<String> categoriesArray = new ArrayList<String>();
        //i - number of match for xPath, so we start count from 1
        for (int i = 1; i <= numberOfCategories; i++){
            categoriesArray.add(driver.findElement(By.xpath("(//a[contains(@href,'category')])[" + i + "]")).getText());
        }
        System.out.println("List of categories on Start page(" + categoriesArray.size() + "):");
        System.out.println(categoriesArray);

        //open Catalogue
        driver.get(baseURL + "frontpage/produktsiya");
        int numberOfCategoriesCatalogue = driver.findElements(By.xpath(".//div[@class = 'category']//a[contains(@href,'category')]")).size();
        List<String> categoriesArrayCatalogue = new ArrayList<String>();
        //i - number of match for xPath
        for (int i = 1; i <= numberOfCategoriesCatalogue; i++){
            categoriesArrayCatalogue.add(driver.findElement(By.xpath("(.//div[@class = 'category']//a[contains(@href,'category')])[" + i + "]")).getText());
        }
        System.out.println("List of categories on Catalogue page(" + categoriesArrayCatalogue.size() + "):");
        System.out.println(categoriesArrayCatalogue);

        //compareListsByElements method is used to return boolean value and track the difference between arrays (e.g. by size or by specific element)
        assertTrue("Lists of categories on Start page and on Catalogue page are not equal", CompareArrays.compareListsByElements(categoriesArrayCatalogue, categoriesArray));
    }

    @Test
    public void verifyCategoryFormat(){
        driver.get(baseURL + "frontpage/produktsiya");
        driver.manage().window().maximize();

        int numberOfCategories = driver.findElements(By.xpath(".//div[@class=\"category\"]//a")).size();
        List<String> categoriesList = new ArrayList<>();
        for (int i = 1; i <= numberOfCategories; i++){
            categoriesList.add(driver.findElement(By.xpath("(.//div[@class=\"category\"]//a)[" + i + "]")).getText());
            assertTrue("Wrong category name: " + categoriesList.get(i-1),categoriesList.get(i-1).matches("[\\p{IsCyrillic}-]+"));
            //it will fail if sibling node with count will not be found
            String correspondingNumber = driver.findElement(By.xpath("(.//div[@class=\"category\"]//a)[" + i + "]/following-sibling::span")).getText();
            System.out.println(correspondingNumber);
            assertTrue("Wrong count format for category: " + categoriesList.get(i-1) + correspondingNumber, correspondingNumber.matches("\\([0-9]+\\)"));
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
