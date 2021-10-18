package org.example;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserPageTest extends BaseTest  {
    protected Clients clients;
    protected UserPage userPage;
    String emailID = "john.mird+591@gmail.com";
    @BeforeClass
    public void usersPageTestClassSetup() throws IOException {
        BOUserLoginCreds BO = new BOUserLoginCreds();
        BO.initialize();
        loginPage.doLogin(getEmailIDfromFile(), getPasswordfromFile());


    }

    @Test(priority = 0)
    public void addUsersTest() throws InterruptedException {

        ClientsPage clientsPage = PageFactory.initElements(chrome , ClientsPage.class);
        clientsPage.goToUsers();
        clientsPage.addUserDetails(emailID , true , true, true , true, true);
        String addMessage = clientsPage.successText.getAttribute("innerHTML");
        Assert.assertEquals(addMessage , "An invitation was sent to " +emailID);


    }

    @Test(priority = 1)
    public void editUserTest() throws InterruptedException {
        chrome.navigate().refresh();
        UserPage userPage = PageFactory.initElements(chrome , UserPage.class);
        userPage.editUser(emailID , true , false , false , true
         ,true);

    }

    @Test(priority = 2)
    public void deleteUsersTest() throws InterruptedException {
        chrome.navigate().refresh();
        UserPage userPage = PageFactory.initElements(chrome , UserPage.class);

        String cancelMessage = userPage.cancelUser(emailID);
        Assert.assertEquals(cancelMessage , "An invitation to "+ emailID + " was cancelled");

    }

}
