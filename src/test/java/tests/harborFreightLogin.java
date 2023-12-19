package tests;

import base.BaseTest;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pageActions.hfLoginPageActions;

public class harborFreightLogin extends BaseTest {

    hfLoginPageActions loginPage = new hfLoginPageActions();

    @Test
    public void hfLoginTest () throws InterruptedException {

        // Enters email and password then clicks login button.
        loginPage.EnterLoginCredentials();
        Reporter.log("Attempted to login.");
    }
}
