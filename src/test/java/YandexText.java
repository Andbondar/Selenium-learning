import YandexUa.PageInstance;
import YandexUa.StartPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Student on 4/15/2015.
 */
public class YandexText extends PageInstance {
    private String baseURL;

    @Before
    public void setUp(){
        setBrowser("FF");
        startPage = new StartPage(driver);
    }

    @Test
    public void testYaRu(){
        startPage.open();
        resultsPage = startPage.sendSearchRequest("Test search");
        resultsPage.resultList().get(0).getLink().click();
    }

    @After
    public void tearDown(){
        driver.close();
    }



}
