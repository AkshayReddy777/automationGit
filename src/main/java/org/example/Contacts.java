package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contacts {
    protected WebDriver chrome;
    @FindBy(css = "a[href=\"/contacts\"]")
    protected WebElement contacts;

    public Contacts(WebDriver driver) {
        chrome = driver;
    }
    public void openContacts (WebDriver chrome){
        contacts.click();
    }
}
