package pageActions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.ElementFetch;
import pageObjects.hfLoginPageElements;

import static base.BaseTest.driver;

public class hfLoginPageActions {

    ElementFetch ele = new ElementFetch();

    public void EnterLoginCredentials() {
        ele.getWebElement("ID", hfLoginPageElements.emailTextBox).sendKeys("testEmail");
        ele.getWebElement("ID", hfLoginPageElements.passwordTextBox).sendKeys("testPassword");
        ele.getWebElement("XPATH", hfLoginPageElements.signInButton).click();
    }

}
