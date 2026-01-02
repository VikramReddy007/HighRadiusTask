package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TaskOne;

public class TestOneStepDef {
    TaskOne taskOne = new TaskOne();
    @Given("Login to opensource website")
    public void loginToOpensourceWebsite() {
        taskOne.loginToApplication();
    }

    @And("Go to admin tab")
    public void goToAdminTab() {
        taskOne.navigateToAdminTab();
    }

    @When("I click on Admin tab to add user")
    public void iClickOnAdminTabToAddUser() {
        taskOne.addUser();
    }

    @And("Enter values in all required fields and click Add")
    public void enterValuesInAllRequiredFieldsAndClickAdd() {
        taskOne.enterUserDetails();
    }

    @Then("Verify Success message")
    public void verifySuccessMessage() {
        taskOne.validateSuccessMessage();
    }

//    protected Scenario scenario;

//    @Before
//    public void currentScenario(Scenario scenario){
//        this.scenario = scenario;
//    }
//
//    @AfterStep
//    public void attachScreenshot(){
//        scenario.attach(WebUtils.getScreenShot(),"image/png", "Click to see image");
//    }
}
