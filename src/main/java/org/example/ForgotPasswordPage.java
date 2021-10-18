package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ForgotPasswordPage extends BOUserLoginCreds {

    protected WebDriver driver;
    @FindBy(css = "input.form-control.empty")
    protected WebElement emailID;
    @FindBy(css = "span.help-block.error.text-left.d-block")
    protected WebElement errorMsg;
    @FindBy(css = "div.alert.alert-success.text-left")
    protected WebElement successMsg;
    @FindBy(css = "button.btn.btn-primary.btn-block")
    protected WebElement submit;
    @FindBy(css = "span.help-block.error.text-left.d-block")
    protected WebElement emptyMsg;


    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
//        PageFactory.initElements(driver , this);
//        emailID = driver.findElement(By.name("email"));
//        submit = driver.findElement(By.cssSelector("button[type='submit']"));
//        errorMsg = driver.findElement(By.cssSelector("span.help-block.error.text-left.d-block"));
//        successMsg = driver.findElement(By.cssSelector("div.alert.alert-success.text-left"));

    }

    public String errorMessageOutput (){
        LoginPage newLogin = new LoginPage(driver);
       PageFactory.initElements(driver , this);
        newLogin.initiateForgotPassword();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        emailID.sendKeys("madhoo@zodha.in");
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        submit.click();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        return errorMsg.getText();
    }

    public String emptyCredentialsMsg(){
        LoginPage newLogin = new LoginPage(driver);
        PageFactory.initElements(driver , this);
        newLogin.initiateForgotPassword();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        emailID.sendKeys("");
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        submit.click();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        return emptyMsg.getText();

    }

    public String successfullyResetMsg(){
        LoginPage newLogin = new LoginPage(driver);
        PageFactory.initElements(driver , this);
        newLogin.initiateForgotPassword();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        emailID.sendKeys(getEmailIDfromFile());
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        submit.click();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        return successMsg.getText();

    }

}
