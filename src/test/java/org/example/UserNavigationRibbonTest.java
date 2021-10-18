package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UserNavigationRibbonTest extends BaseTest {
    protected WebDriver chrome;
    protected UserNavigationRibbon testdash;
    protected Dashboard newDash;


    @BeforeClass
    public void userNavClassSetup() throws IOException {

        // Open chrome browser => Chrome browser should be open
        loginPage.doLogin(getEmailIDfromFile(), getPasswordfromFile());
        testdash = new UserNavigationRibbon(chrome);
    }
    @Test
    public void openDashboard(){
//           login.doLogin("madhoo@zodha.com" , "123123Aa@");
        UserNavigationRibbon testDash = new UserNavigationRibbon(chrome);
        testDash.openNavOption("Dashboard");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/home");

    }

    @Test
    public void openCampaign(){
        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Campaigns");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/campaigns");
    }
    @Test
    public void openClients(){
        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Clients");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/clients");
    }
    @Test
    public void openContacts(){
        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Contacts");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/contacts");
    }
    @Test
    public void openEmailAccounts(){

        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Email Accounts");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/email-accounts");
    }
    @Test
    public void openAggregateReports(){


        testdash.openNavOption("Aggregate Reports");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/reports/campaign-aggregates");


    }
    @Test
    public void openDateReports(){

        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Date Range Reports");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/reports/date-range");
    }
    @Test
    public void openLinkedIn(){

        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("LinkedIn");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/linkedin-access-request/create");
    }
    @Test
    public void openSettings(){

        testdash = new UserNavigationRibbon(chrome);
        testdash.openNavOption("Settings");
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha2.wavo.co/settings");
    }

}
