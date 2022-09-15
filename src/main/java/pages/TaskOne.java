package pages;

import Steps.TestOneStepDef;
import io.cucumber.java.Scenario;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebUtils;

import java.util.Random;

public class TaskOne extends BasePage {

    @FindBy(id = "txtUsername")
    WebElement userName;

    @FindBy(id = "txtPassword")
    WebElement passwordField;

    @FindBy(id = "btnLogin")
    WebElement loginButton;

    @FindBy(id="menu_admin_viewAdminModule")
    WebElement adminLink;

    @FindBy(id="btnAdd")
    WebElement addButton;

    @FindBy(id="systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(id="systemUser_userName")
    WebElement newUserName;

    @FindBy(id="systemUser_password")
    WebElement newPassword;

    @FindBy(id="systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(id="btnSave")
    WebElement saveButton;

    public TaskOne(){
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebUtils.waitForPageLoad();
        driver.manage().window().maximize();
        userName.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        WebUtils.waitForSeconds(2);
        WebUtils.highlightElement(loginButton);
        loginButton.click();
        WebUtils.waitForPageLoad();
    }

    public void navigateToAdminTab() {
        WebUtils.highlightElement(adminLink);
        adminLink.click();
        WebUtils.waitForPageLoad();
    }

    public void addUser() {
        WebUtils.highlightElement(addButton);
        addButton.click();
        WebUtils.waitForPageLoad();
    }

    public void enterUserDetails() {
        employeeName.sendKeys("David Morris");
        newUserName.sendKeys("newUser"+ RandomString.make(3));
        newPassword.sendKeys("passwordUser1");
        confirmPassword.sendKeys("passwordUser1");
        WebUtils.waitForSeconds(3);
        WebUtils.highlightElement(saveButton);
        saveButton.click();
        WebUtils.waitForPageLoad();
    }

    public void validateSuccessMessage() {
        if(driver.findElements(By.xpath("//*[contains(text(), 'Successfully Saved')]")).size()>0){
            WebUtils.waitForSeconds(5);
            System.out.println("Success message is displayed");
        }
        else System.out.println("Success message is not displayed");
    }
}
