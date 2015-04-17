package HomeWork03;

import Kapeluh.StartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by bondar on 4/16/2015.
 */
public class KapeluhTests extends Kapeluh.PageInstance{

    @Before
    public void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
    }

    @Test
    public void checkHats(){
        startPage.open();
        cataloguePage = startPage.openCatalogue();
        damskieShlyapki = cataloguePage.openDamskieShlyapki();
        damskieShlyapki.checkTeaserItemsStructure();
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
