package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserAvatarRibbon {

    protected WebDriver chrome;
    protected WebElement logo;
    protected WebElement userAvatar;
    protected WebElement settingsOption;
    protected WebElement logout;
    protected WebElement alerts;
    protected WebElement notificationHeader;
    List<WebElement> notificationsContent;

    public void UserNavigationRibbon(WebDriver driver) {
        chrome = driver;
        logo = driver.findElement(By.cssSelector("div.navbar-header > a > span > img:first-child")) ;
        userAvatar = driver.findElement(By.cssSelector("#site-navbar-collapse > ul > li > a.nav-link.navbar-avatar > span")) ;
        settingsOption = driver.findElement(By.cssSelector(".dropdown-menu.profile-dropdown.show > a:nth-child(1)")) ;
        logout = driver.findElement(By.cssSelector(".dropdown-menu.profile-dropdown.show > a:nth-child(2)")) ;
        alerts = driver.findElement(By.cssSelector(".icon.wb-bell")) ;
        notificationHeader = driver.findElement(By.cssSelector("div[class='dropdown-menu-header'] h5")) ;
        notificationsContent = driver.findElements(By.cssSelector("div[role='menu'.show"));

    }

    public void getBackgroundColor() {
        WebElement elm = chrome.findElement(By.cssSelector("div.navbar-header"));
        elm.getCssValue("background-color");
            }

    public void getSettings() {
        Settings setting = new Settings(chrome);
        setting.openSettings(chrome);

    }
    public void getLogOut() {
        Dashboard newDashboard = new Dashboard(chrome);
        newDashboard.doLogout();

    }
//    public boolean doesNotificationExist(){
//
//        if()
//
//        return false;
//    }

}
