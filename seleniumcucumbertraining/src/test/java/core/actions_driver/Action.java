package core.actions_driver;

import org.openqa.selenium.WebElement;
import pages_objects.BasePage;

import java.util.concurrent.TimeUnit;

public class Action extends BasePage {
    public Action() {
        super();
    }
//    public static WebDriver driver;
    // WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void enterValue(WebElement element, String data) {
        element.clear();
        element.sendKeys(data);
    }

    public void clickElement(WebElement element) {
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        waitForElementToBeClickable(element);
        element.click();
    }

    public static String findElement(WebElement locator) {
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        return locator.getText();
    }

    public void clearElement(WebElement element) {
        getDriver().manage().timeouts().implicitlyWait
                (Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
        waitForElementToBeClickable(element);
        element.clear();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public String getTooltipText(WebElement element) {
        return element.getAttribute("validationMessage");
    }
}