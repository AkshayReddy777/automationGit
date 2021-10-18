package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseClass {

    @FindBy(name = "email")
    protected WebElement userName;

    @FindBy(name = "password")
    protected WebElement password;

    @FindBy(css = "button[type='submit']")
    protected WebElement submitButton;

    @FindBy(css = "a[href='https://zodha2.wavo.co/password/reset']")
    protected WebElement forgotPasswordLink;

    public LoginPage(WebDriver driver){
        super(driver);
    }


    public void doLogin(String email, String pass) {
        System.out.println(email);
        userName.sendKeys(email);
        password.sendKeys(pass);
        submitButton.click();
    }

    public void initiateForgotPassword() {
        forgotPasswordLink.click();
    }

    public void loginWithInvalidCredentials() throws IOException {
        doLogin("email@gmail.com" , "231456");
    }
    public void loginWithEmptyCredentials() throws IOException {
        doLogin("","");
    }

    public String getLoginErrorMessage() {
        WebElement errorMessage = driver.findElement(By.cssSelector("li:nth-child(1)"));
        return errorMessage.getAttribute("innerHTML");
    }

}
