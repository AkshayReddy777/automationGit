package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


import static java.util.concurrent.TimeUnit.SECONDS;

public class UserPage {

    protected WebDriver driver;
    @FindBy(xpath = "//div[@class='card-block p-15']")
    protected List<WebElement> emailIDs;

//    @FindBy(css = "button.btn.btn-default")
//    protected WebElement editButton;
    @FindBy(xpath = "//*[@id=\"updateInviteRoleModal\"]/div/div/div[2]/div[6]/button/span")
    protected WebElement updateButton;
    @FindBy(css = "div.swal-button-container>button.swal-button--confirm")
    protected WebElement confirmCancelButton;
    @FindBy(css = "div.swal-text")
    protected WebElement cancelMessage;

    @FindBy(css = "div.swal-button-container")
    protected WebElement okButton;
    @FindBy(css = "#inviteCampaignRoleView")
    protected WebElement viewCampaigns;
    @FindBy(css = "#inviteCampaignRoleEdit")
    protected WebElement editCampaigns;
    @FindBy(css = "#inviteCampaignRoleExport")
    protected WebElement exportData;
    @FindBy(css = "#inviteLinkedinRoleRead")
    protected WebElement linkedIn;
    @FindBy(css = "#inviteLinkedinRoleEdit")
    protected WebElement editlinkedIn;



    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public String cancelUser(String emailID) throws InterruptedException {

        Clients clients = PageFactory.initElements(driver, Clients.class);

        clients.openClients(driver);
        ClientsPage clientsPage = PageFactory.initElements(driver, ClientsPage.class);
        clientsPage.goToUsers();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
        for (WebElement present : emailIDs) {
            System.out.println(present.getText());
            if (present.getText().contains(emailID)) {
                Thread.sleep(1000);

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,250)", "");
                WebElement cancelButton = present.findElement(By.cssSelector("button.btn-warning"));
                cancelButton.click();
                driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
                confirmCancelButton.click();
                Thread.sleep(5000);
                String getMessage = cancelMessage.getAttribute("innerText");
                okButton.click();
                System.out.println(getMessage);
                return getMessage;

            }

        }
        return "failed";
    }

    public void editUser(String emailID , boolean viewCampaign, boolean editCampaign , boolean dataExport  ,boolean viewLinkedIn , boolean linkedInEdit ) throws InterruptedException {

        Clients clients = PageFactory.initElements(driver, Clients.class);

        clients.openClients(driver);
        ClientsPage clientsPage = PageFactory.initElements(driver, ClientsPage.class);
        clientsPage.goToUsers();
        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);

        for (WebElement present : emailIDs) {
            System.out.println(present.getText());
            if (present.getText().contains(emailID)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,250)", "");
                WebElement editButton = present.findElement(By.cssSelector("button.btn-default"));
                driver.manage().timeouts().pageLoadTimeout(100, SECONDS);
                editButton.click();
                if(!viewCampaigns.isSelected() && viewCampaign == true) { viewCampaigns.click();};
                Thread.sleep(1000);
                if(!editCampaigns.isSelected() && editCampaign == true) {editCampaigns.click();};
                Thread.sleep(1000);
                if(!exportData.isSelected() && dataExport == true) {exportData.click();};
                Thread.sleep(1000);
                if(!linkedIn.isSelected() && viewLinkedIn == true) {linkedIn.click();};
                Thread.sleep(1000);
                if(!editlinkedIn.isSelected() &&  linkedInEdit == true) {editlinkedIn.click();};
                Thread.sleep(1000);
                updateButton.click();
            }
        }
    }
}
