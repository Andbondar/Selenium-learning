package CucumberTests.StepDefinitions;

import CucumberTests.PageInstance;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by Student on 4/17/2015.
 */
public class SearchResultsPage extends PageInstance{
    @Then("^I open first link$")
    public void I_open_first_link() throws Throwable {
        resultsPage.resultList().get(0).getLink().click();
    }
}
