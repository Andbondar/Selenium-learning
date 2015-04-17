package CucumberTests.StepDefinitions;

import CucumberTests.PageInstance;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by Student on 4/17/2015.
 */
public class YandexStartPage extends PageInstance{
    @Given("^I am on Yandex start page$")
    public void I_am_on_Yandex_start_page(){
        startPage.open();
    }

    @When("^I search \"([^\"]*)\"$")
    public void I_search(String inputString){
        resultsPage = startPage.sendSearchRequest(inputString);
    }
}
