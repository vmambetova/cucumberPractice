package pages_objects;


import core.driver_manager.DriverManagers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends DriverManagers {
    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;

    private WebDriverWait wait;

    public BasePage() {
        wait = new WebDriverWait(getDriver(), TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(getDriver(), TIMEOUT), this);
    }

    protected void waitForElementToBeClickable(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}