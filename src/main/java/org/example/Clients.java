package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Clients {
    protected WebDriver chrome;
    @FindBy(css = "a[href=\"/clients\"]")
    protected WebElement clients;

    public Clients(WebDriver driver) {
        chrome = driver;
        clients = driver.findElement(By.cssSelector("a[href=\"/clients\"]"));
    }
    public void openClients (WebDriver chrome){
        clients.click();
    }
}
