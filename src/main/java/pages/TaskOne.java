package pages;

import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import utils.WebUtils;

public class TaskOne extends BasePage {

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @FindBy(className="oxd-main-menu-item")
    WebElement adminLink;

    @FindBy(xpath = "//button[@type='button' and text()=' Add ']")
    WebElement addButton;

    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement employeeName;

    @FindBy(xpath = "//div/*[contains(text(), 'Username')]/following::div/input")
    WebElement newUserName;

    @FindBy(xpath = "//div/*[contains(text(), 'Password')]/following::div/input")
    WebElement newPassword;

    @FindBy(xpath = "//div/*[contains(text(), 'Confirm Password')]/following::div/input")
    WebElement confirmPassword;

    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Save']")
    WebElement saveButton;

    @FindBy(xpath = "//div/*[contains(text(), 'User Role')]/following::div")
    WebElement userRoleDrpDwn;



    public TaskOne(){
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebUtils.waitForPageLoad();
        driver.manage().window().maximize();
        WebUtils.waitForSeconds(3);
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
        employeeName.sendKeys("Ranga Akunuri");
        newUserName.sendKeys("newUser"+ RandomString.make(3));
        newPassword.sendKeys("passwordUser1");
        confirmPassword.sendKeys("passwordUser1");
        WebUtils.waitForSeconds(3);
        driver.findElement(By.xpath("//div/*[contains(text(), 'User Role')]/following::div")).click();
        WebUtils.waitForSeconds(1);
        driver.findElement(By.xpath("//div/*[contains(text(), 'User Role')]/following::div[@role='listbox']//div[@role='option']//*[text()='Admin']")).click();
        WebUtils.waitForSeconds(1);
        driver.findElement(By.xpath("//div/*[contains(text(), 'Status')]/following::div")).click();
        WebUtils.waitForSeconds(1);
        driver.findElement(By.xpath("//div/*[contains(text(), 'Status')]/following::div[@role='listbox']//div[@role='option']//*[text()='Enabled']")).click();
        WebUtils.waitForSeconds(1);
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
