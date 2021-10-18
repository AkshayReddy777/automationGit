package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Settings {

    protected WebDriver chrome;
    protected WebElement settings;

    public Settings(WebDriver driver) {
        chrome = driver;
        settings = driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(8) > a:nth-child(1) > span:nth-child(2)"));
    }
    public void openSettings (WebDriver chrome){
        settings.click();
    }
    public void logOut (WebDriver chrome) {
    }



}
