package org.example;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;


public class LoginPageTest extends BaseTest {

    protected ForgotPasswordPage forgotPasswordPage;


    @BeforeMethod
    public void methodSetup() {
        // Go to login url => Login page should shown and it is accessible
//      /  chrome.get(getUrlfromFile());
        loginPage = PageFactory.initElements(chrome, LoginPage.class);
    }

   @Test(priority = 0, enabled = true)
    public void validUserLoginTestCase() throws IOException {
       // As valid user, I can login to Wavo application

       // complete login with valid credentials => Login should be successful and Backoffice is accessible
       loginPage.doLogin(getEmailIDfromFile(), getPasswordfromFile());
       String notificationsSelector = "a[title='Notifications']";
       Assert.assertEquals(chrome.findElement( By.cssSelector(notificationsSelector)).isEnabled(), true);
       Assert.assertEquals(chrome.getTitle(), "Madhoo Bandi");
       WebElement userAvatar = chrome.findElement(By.cssSelector("a.nav-link.navbar-avatar"));
       userAvatar.click();
       WebElement logoutOption = chrome.findElement(By.cssSelector("a[href='/logout']"));
       logoutOption.click();

    }

    @Test(priority = 3, enabled = true)
    public void forgotPassword() throws InterruptedException {
        loginPage.initiateForgotPassword();

Thread.sleep(500);
        Assert.assertEquals(chrome.getCurrentUrl(), "https://zodha2.wavo.co/password/reset");
//        Assert.assertEquals(chrome.getTitle(), "Reset Password - Madhoo Bandi");
//        WebElement resetButton = chrome.findElement(By.cssSelector("button.btn.btn-primary.btn-block"));
//        Assert.assertEquals(resetButton.getText(), "Reset Password");

    }



    @Test(priority = 1, enabled = true)
    public void invalidUserCredentialsTest() throws IOException {
        loginPage.loginWithInvalidCredentials();

    }
    @Test(priority = 2, enabled = true)
    public void emptyUserCredentialsTest() throws IOException {
        loginPage.loginWithEmptyCredentials();
        Assert.assertEquals(loginPage.getLoginErrorMessage() , "The password field is required.");
    }

}
