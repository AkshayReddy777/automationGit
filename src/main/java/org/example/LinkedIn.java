package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedIn {
    protected WebDriver chrome;
    @FindBy(css = "a[href=\"/linkedin-access-request/create\"]")
    protected WebElement linkedIn;

    public LinkedIn(WebDriver driver) {
        chrome = driver;
        linkedIn = driver.findElement(By.cssSelector("a[href=\"/linkedin-access-request/create\"]"));
    }
    public void openLinkedIn (WebDriver chrome){
        linkedIn.click();
    }
}
