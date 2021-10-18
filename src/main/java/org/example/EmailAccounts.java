package org.example;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailAccounts {

    protected WebDriver chrome;
    @FindBy(css ="a[href='/email-accounts']")
    protected WebElement emailAccounts;

    public EmailAccounts(WebDriver driver) {
        chrome = driver;
        emailAccounts = driver.findElement(By.cssSelector("a[href=\"/email-accounts\"]"));
    }
    public void openEmail(){
        emailAccounts.click();
    }
}
