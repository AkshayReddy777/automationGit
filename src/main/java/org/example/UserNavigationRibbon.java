package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;

public class UserNavigationRibbon {

    protected WebDriver chrome;
    List<WebElement> navigationOptions;
    WebElement aggregateElement;
    WebElement dateElement;


    public UserNavigationRibbon(WebDriver driver) {
        chrome = driver;
        navigationOptions = chrome.findElements(By.cssSelector("div > ul.site-menu > li > a"));
    }


    public void openNavOption(String optionName){

        if (optionName == "Dashboard") {
            navigationOptions.get(0).click();
        } else if(optionName == "Campaigns") {
            navigationOptions.get(1).click();
        }
        else if(optionName == "Clients") {
            navigationOptions.get(2).click();
        }
        else if(optionName == "Email Accounts") {
            navigationOptions.get(3).click();
        }
        else if(optionName == "LinkedIn") {
            navigationOptions.get(4).click();
        }
        else if(optionName == "Contacts") {
            navigationOptions.get(5).click();
        }
        else if(optionName == "Aggregate Reports") {
            navigationOptions.get(6).click();
            aggregateElement = chrome.findElement(By.cssSelector("a[href = '/reports/campaign-aggregates']"));
            aggregateElement.click();

        }
        else if(optionName == "Date Range Reports") {
            navigationOptions.get(6).click();
            dateElement =  chrome.findElement(By.cssSelector("a[href = '/reports/date-range']"));
            dateElement.click();
        }
        else if(optionName == "Settings") {
            navigationOptions.get(7).click();
        }
    }
}
