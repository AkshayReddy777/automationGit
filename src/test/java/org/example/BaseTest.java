package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BOUserLoginCreds {

    protected WebDriver chrome;
    protected LoginPage loginPage;


    @BeforeClass
    public void classSetup() throws IOException {

        String valuefrommaven = System.getProperty("propertyName");
        System.out.println(valuefrommaven);


        String cloudURL = "";

        if(valuefrommaven.equals("BrowserStack")) {
            cloudURL = TargetCloudSelection4Test.getBrowserStackUrl();
        } else if(valuefrommaven.equals("SauceLabs")) {
            cloudURL = TargetCloudSelection4Test.getSauceLabsUrl();
        } else if(valuefrommaven.equals("LambdaTest")) {
            cloudURL = TargetCloudSelection4Test.getLambdaTestUrl();
        }

        System.out.println("Cloud URL : " + cloudURL);
        chrome = new RemoteWebDriver(new URL(cloudURL), TargetCloudSelection4Test.getCapabilities());
        BOUserLoginCreds.initialize();
        chrome.get(BOUserLoginCreds.getUrlfromFile());

        loginPage = PageFactory.initElements(chrome, LoginPage.class);

    }

}
