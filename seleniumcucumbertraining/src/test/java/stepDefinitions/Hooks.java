package stepDefinitions;

import core.driver_manager.DriverManagers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks extends DriverManagers {


    @Before
    public void setupBrowser() {
        loadConfig();
        launchApp();
    }

    @After
    public void closeBrowser() {
        tearDown();
    }
}
