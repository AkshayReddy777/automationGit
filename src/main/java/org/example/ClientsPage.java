package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class ClientsPage {

    protected WebDriver driver;


    @FindBy(css = "i.icon.wb-users")
    protected WebElement usersButton;
    @FindBy(css = "div.col-6.col-sm-6.col-md-6.text-right > button > span.hidden-sm-down")
    protected WebElement addUserButton;
    @FindBy(css = "input.form-control")
    protected WebElement emailIDInput;
    @FindBy(css = "#userInviteRoleView")
    protected WebElement viewCampaigns;
    @FindBy(css = "#userInviteRoleEdit")
    protected WebElement createCampaigns;
    @FindBy(css = "#userInviteRoleExport")
    protected WebElement exportData;
    @FindBy(css = "#userInviteLinkedinRoleRead")
    protected WebElement viewLinkedIn;
    @FindBy(css = "#userInviteLinkedinRoleEdit")
    protected WebElement createLinkedInSearches;
    @FindBy(css = "div#sendInvitationModal > div.modal-dialog >div> div.modal-body > div.text-center >button.btn.btn-primary > span > i.icon.wb-chevron-right")
    protected WebElement sendButton;
    @FindBy(css = "div.swal-text")
    protected WebElement successText;

    @FindBy(css =  "BUTTON.swal-button.swal-button--confirm")
    protected WebElement okButton;


    public ClientsPage( WebDriver driver){
        this.driver = driver;
    }

    public void goToUsers(){

        Clients clientOption = new Clients(driver);
        clientOption.openClients(driver);
        usersButton.click();

    }
    public void addUserDetails(String emailID , Boolean a, Boolean b, Boolean c, Boolean d, Boolean e  ) throws InterruptedException {

        addUserButton.click();
        emailIDInput.sendKeys(emailID);
        if(a = true) {viewCampaigns.click();};
        Thread.sleep(1000);
        if(b = true) {createCampaigns.click();};
        Thread.sleep(1000);
        if(c = true) {exportData.click();};
        Thread.sleep(1000);
        if(d = true) {viewLinkedIn.click();};
        Thread.sleep(1000);
        if(e = true) {createLinkedInSearches.click();};
        sendButton.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        okButton.click();
    }


}
