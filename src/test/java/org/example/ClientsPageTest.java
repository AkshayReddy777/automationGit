package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ClientsPageTest extends BaseTest {

    @BeforeClass
    public void clientsPageTestClassSetup() throws IOException {
        loginPage.doLogin(getEmailIDfromFile(), getPasswordfromFile());
    }

    @Test
    public void addUsersTest() throws InterruptedException {

        ClientsPage clientsPage = PageFactory.initElements(chrome , ClientsPage.class);
        clientsPage.goToUsers();
        String e = "john.mird+abcffff@gmail.com";
        Thread.sleep(500);
        clientsPage.addUserDetails(e , true , true, true , true, true);
        String s = clientsPage.successText.getAttribute("innerHTML");
        Assert.assertEquals(s , "An invitation was sent to " +e);


    }

}
