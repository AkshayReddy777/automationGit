package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import sun.text.resources.cldr.ext.FormatData_as;

public class Dashboard {

    protected WebDriver chrome;
    @FindBy(css ="a[href=\"/home\"]")
    protected WebElement dashBoard;


    public Dashboard(WebDriver driver) {
        chrome = driver;
    }

    public void openDashboard() {

        dashBoard.click();

    }

    public void doLogout() {
        WebElement userAvatar = chrome.findElement(By.cssSelector("a.nav-link.navbar-avatar"));
        userAvatar.click();
        WebElement logoutOption = chrome.findElement(By.cssSelector("a[href='/logout']"));
        logoutOption.click();
    }
}
