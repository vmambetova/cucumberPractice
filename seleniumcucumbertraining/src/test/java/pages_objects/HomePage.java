package pages_objects;

import core.actions_driver.Action;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    Action action = new Action();
    public HomePage(){
        PageFactory.initElements(getDriver(), this);
    }
    public HomePage openHomePage() {
        getDriver().get(prop.getProperty("url"));
        return new HomePage();
    }
}
