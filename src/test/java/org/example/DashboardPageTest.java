package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DashboardPageTest extends BaseTest {
    protected WebDriver chrome;
//    protected LoginPage loginPage;
    Dashboard dashboardPage;
    UserNavigationRibbon navOptions;

    @BeforeClass
    public void dashboardClassSetup() throws IOException {

        // Open chrome browser => Chrome browser should be open
        BOUserLoginCreds BO = new BOUserLoginCreds();
        BO.initialize();
        loginPage.doLogin(getEmailIDfromFile(), getPasswordfromFile());
        dashboardPage = new Dashboard(chrome);
    }

    @BeforeMethod
    public void methodSetup() {
        // Go to login url => Login page should shown and it is accessible
//        chrome.get("https://zodha.wavo.co/login");
//        loginPage = new LoginPage(chrome);
//        loginPage.doLogin("madhoo@zodha.com", "123123Aa@");
//        dashboardPage = new Dashboard(chrome);
    }

    @AfterMethod
    public void methodCleanUp() {
        //dashboardPage.doLogout();
    }

    @Test
    public  void dashboardPageTest(){
        Dashboard newDash = new Dashboard(chrome);
        newDash.openDashboard();

//        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/home");
    }

    @Test
    public void campaignPageTest (){

        Campaigns campaignpage = new Campaigns(chrome);
        campaignpage.goToCampaigns();
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/campaigns");

    }

    @Test
    public void clientsPageTest(){
        Clients clientsPage = new Clients(chrome);
        clientsPage.openClients(chrome);
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/clients");
    }

    @Test
    public void emailAccountsPageTest(){
        EmailAccounts emailpage = new EmailAccounts(chrome);
        emailpage.openEmail();
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/email-accounts");
    }

    @Test
    public void contactsPage(){
        Contacts contactPage = new Contacts(chrome);
        contactPage.openContacts(chrome);
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/contacts");
    }

    @Test
    public void linkedInPage(){
        LinkedIn linkedinPage = new LinkedIn(chrome);
        linkedinPage.openLinkedIn(chrome);
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/linkedin-access-request/create");
    }

    @Test
    public void settingsPage(){
        Settings settingsinPage = new Settings(chrome);
        settingsinPage.openSettings(chrome);
        Assert.assertEquals(chrome.getCurrentUrl() , "https://zodha.wavo.co/settings");
    }

    @Test
    public void aggregatePage() throws InterruptedException {
        Reports report = new Reports(chrome);
        report.openAggregateReport(chrome);

    }

    @Test
    public void dateReportPage() throws InterruptedException {
        Reports report = new Reports(chrome);
        report.openDateReport(chrome);

    }

}
