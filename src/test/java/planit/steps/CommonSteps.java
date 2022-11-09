package planit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import planit.pages.PageBase;
import planit.utilities.TestConfiguration;
import planit.webdriver.ApplicationDriver;

import java.util.List;
import java.util.Map;


public class CommonSteps {

    @Given("I navigate to {string} home page")
    public void navigateToAppHomePage(String appName) {
        ApplicationDriver.initializeDriver();
        TestConfiguration.changeActiveDataSet(appName);
        String url = TestConfiguration.getValue("url");
        ApplicationDriver.getActiveDriver().get(url);
    }

    @And("I click {string} on {string} page")
    public void clickElement(String name, String pageName) {
        PageBase pageBase = PageBase.getPage(pageName);
        pageBase.click(name);
    }

    @Then("verify that the following is displayed on {string} page")
    public void verifyDisplayed(String pageName, List<String> nameList) {
        PageBase pageBase = PageBase.getPage(pageName);
        pageBase.verifyDisplayed(nameList);
    }

    @Then("verify that the following is not displayed on {string} page")
    public void verifyNotDisplayed(String pageName, List<String> nameList) {
        PageBase pageBase = PageBase.getPage(pageName);
        pageBase.verifyNotDisplayed(nameList);
    }

    @And("I populate the following fields on {string} page")
    public void populateFields(String pageName, DataTable dataTable) {
        PageBase pageBase = PageBase.getPage(pageName);
        List<Map<String, String>> fieldsMap = dataTable.asMaps(String.class, String.class);
        pageBase.populateFields(fieldsMap.get(0));
    }

    @And("I go to {string} page")
    public void goToPage(String name) {
        PageBase pageBase = PageBase.getPage("Home");
        pageBase.click(name);
    }

}
