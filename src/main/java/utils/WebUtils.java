package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WebUtils {

    public static void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(10));
        wait.until(input -> (Function<WebDriver, Boolean>) driver -> {
            assert driver != null;
            System.out.println("Current Window State       : "
                    + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
            return String
                    .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                    .equals("complete");
        });
    }

    public static void waitForSeconds(double secondCount){
        try {
            Thread.sleep((long) (secondCount*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void highlightElement( WebElement ele) {
        JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;
        String backgroundAttribute = ele.getCssValue("background");
        String borderAttribute = ele.getCssValue("border");
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].scrollIntoView();", ele);
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
        WebUtils.waitForSeconds(0.3);
        js.executeScript("arguments[0].setAttribute('style', 'background: " + backgroundAttribute + "; border: " + borderAttribute + ";');", ele);
        WebUtils.waitForSeconds(0.3);
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
        WebUtils.waitForSeconds(0.3);
        js.executeScript("arguments[0].setAttribute('style', 'background: " + backgroundAttribute + "; border: " + borderAttribute + ";');", ele);
        WebUtils.waitForSeconds(0.3);

        WebUtils.waitForSeconds(0.5);
    }

    public static byte[] getScreenShot() {
        TakesScreenshot scrShot =((TakesScreenshot)BasePage.driver);
//Call getScreenshotAs method to create image file
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }
}
