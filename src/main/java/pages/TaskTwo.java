package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.WebUtils;


import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class TaskTwo extends BasePage {


    public void openHerokuApp() {
        driver.get("https://the-internet.herokuapp.com/");
        WebUtils.waitForPageLoad();
    }

    public void clickOnDropdownLink() {
        driver.findElement(By.linkText("Dropdown")).click();
        WebUtils.waitForPageLoad();
        WebUtils.waitForSeconds(3);
    }

    public void selectOptionInDropdown(int arg0) {
        Select drpDwn = new Select(driver.findElement(By.id("dropdown")));
        drpDwn.selectByIndex(arg0);
        WebUtils.waitForSeconds(2);
        System.out.println("Selected dropdown value is : "+drpDwn.getFirstSelectedOption().getText());
    }

    public void clickOnElementalSelenium() {
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }

    public void navigateToNewTab() {
        Set<String> allWindows = driver.getWindowHandles();
        for(String window: allWindows){
            driver.switchTo().window(window);
            WebUtils.waitForSeconds(2);
        }
        WebUtils.waitForPageLoad();
    }

    public void validateTextIsDisplayed(String arg0) {
        String elementalText = driver.findElement(By.xpath("//h1[contains(text(), 'Elemental Selenium')]")).getText();
        assertThat(elementalText, containsString(arg0));
    }
}