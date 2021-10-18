package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Campaigns {

    protected WebDriver chrome;
    @FindBy(css = "a[href=\"/campaigns\"]")
    protected WebElement campaigns;

    public Campaigns(WebDriver driver) {
        chrome = driver;
    }
    public void goToCampaigns() {
        campaigns.click();
    }


}
