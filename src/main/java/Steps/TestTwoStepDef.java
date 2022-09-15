package Steps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TaskTwo;
import utils.WebUtils;

public class TestTwoStepDef {
    TaskTwo taskTwo;
    protected Scenario scenario;
    public TestTwoStepDef(){
        taskTwo = new TaskTwo();
    }

    @Given("I open the herokuapp website")
    public void iOpenTheHerokuappWebsite() {
        taskTwo.openHerokuApp();
    }

    @When("I click on Dropdown Link")
    public void iClickOnDropdownLink() {
        taskTwo.clickOnDropdownLink();
    }

    @And("Select option {int} in dropdown and validate if the option is selected")
    public void selectOptionInDropdownAndValidateIfTheOptionIsSelected(int arg0) {
        taskTwo.selectOptionInDropdown(arg0);
    }

    @When("I click on Elemental Selenium and new tab is opened")
    public void iClickOnElementalSeleniumAndNewTabIsOpened() {
        taskTwo.clickOnElementalSelenium();
        taskTwo.navigateToNewTab();
    }

    @Then("Assert that {string} text is displayed")
    public void assertThatTextIsDisplayed(String arg0) {
        taskTwo.validateTextIsDisplayed(arg0);
    }

    @Before
    public void currentScenario(Scenario scenario){
        this.scenario = scenario;
    }
//
    @AfterStep
    public void attachScreenshot(){
        scenario.attach(WebUtils.getScreenShot(),"image/png", "Click to see image");
    }
}
