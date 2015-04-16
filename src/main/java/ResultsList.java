import org.openqa.selenium.WebDriver;

import java.util.List;

/**
 * Created by Student on 4/15/2015.
 */
public class ResultsList {
    private WebDriver driver;
    private List<ResultContainer> listOfResults;

    public ResultsList(WebDriver driver){
        this.driver = driver;
    }
    public List<ResultContainer> getResultsList(){
        return this.listOfResults;
    }
    public void addResult(ResultContainer addedResult){
        listOfResults.add(addedResult);
    }
}
