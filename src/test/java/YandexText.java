import org.junit.Before;
import org.junit.Test;

/**
 * Created by Student on 4/15/2015.
 */
public class YandexText extends PageInstance{
    private String baseURL;

    @Before
    public void setUp(){
        setBrowser("FF");
    }

    @Test
    public void testYaRu(){
        StartPage startPage = new StartPage(driver);
        startPage.open();
        ResultsPage resultsPage = startPage.sendSearchRequest("Test search");
    }



}
