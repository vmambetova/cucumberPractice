package pages_objects;

//import core.dataFaker.DataFaker;

import core.actions_driver.Action;
import core.dataFaker.DataFaker;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Data
public class RegisterPage extends BasePage {

    Action action = new Action();
    DataFaker dataFaker = new DataFaker();

    public RegisterPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement myAccountMenu;
    @FindBy(xpath = "//a[text()='Register']")
    public WebElement registerOption;
    @FindBy(id = "input-firstname")
    public WebElement firstName;
    @FindBy(id = "input-lastname")
    public WebElement lastName;
    @FindBy(id = "input-email")
    public WebElement email;
    @FindBy(id = "input-telephone")
    public WebElement telephone;
    @FindBy(id = "input-password")
    public WebElement password;
    @FindBy(id = "input-confirm")
    public WebElement passwordConfirm;
    @FindBy(xpath = "//input[@value=\"0\"]")
    public WebElement radioButtonSubscribe;
    @FindBy(xpath = "//input[@name = \"agree\"]")
    public WebElement privacyPolicyCheckMark;
    @FindBy(css = "input[value='Continue']")
    public WebElement continueButtonRegister;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement continueWhenAccCreated;
    @FindBy(how = How.XPATH, using = "//div[@class='text-danger']")
    public WebElement errorMessages;
    @FindBy(xpath = "//*[@id='content']/h1")
    public WebElement accountCreatedMessage;
    @FindBy(xpath = "(//div[@class='alert alert-danger alert-dismissible'])[1]")
    public WebElement privacyPolicyWarningMessage;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    public WebElement emailAlreadyRegisteredMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'alert-dismissible')]")
    public WebElement warningMsg;

    public RegisterPage clickOnMyAccount() {
        action.waitForElementToBeClickable(myAccountMenu);
        action.clickElement(myAccountMenu);
        return new RegisterPage();
    }

    public RegisterPage clickOnRegister() {
        action.waitForElementToBeClickable(registerOption);
        action.clickElement(registerOption);
        return new RegisterPage();
    }

    public void inputForNewsletterSection() {
        radioButtonSubscribe.click();
        privacyPolicyCheckMark.click();
    }

    public String getText(String text) {
        WebElement locator = getDriver().findElement(By.xpath("//div[@class=\"text-danger\" and text()='" + text + "']"));
        return locator.getText();
    }

    public void enterText(String locator, String text) {
        getDriver().findElement(By.id(locator)).sendKeys(text);
    }
}