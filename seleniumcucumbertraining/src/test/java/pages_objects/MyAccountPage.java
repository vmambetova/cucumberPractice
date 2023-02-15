package pages_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.driver_manager.DriverManagers.getDriver;

public class MyAccountPage extends BasePage {

    public MyAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Edit your')]")
    public WebElement editYourAccountLink;
    @FindBy(xpath = "(//ul[@class='list-unstyled'])[9]")
    public WebElement myAccountBlock;
    @FindBy(xpath = "(//ul[@class='list-unstyled'])[8]")
    public WebElement myOrdersBlock;

}
