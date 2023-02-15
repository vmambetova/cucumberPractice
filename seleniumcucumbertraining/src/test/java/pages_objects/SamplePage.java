package pages_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SamplePage {
    @FindBy(how = How.ID, using = "")
    private WebElement elem1;
    @FindBy(how = How.NAME, using = "")
    private WebElement elem2;
}
