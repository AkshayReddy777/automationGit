package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reports {

    protected WebDriver chrome;
    protected WebElement reports;
    protected WebElement aggreagateReport;
    protected WebElement dateRangeReport;

    public Reports(WebDriver driver) throws InterruptedException {
        chrome = driver;
        Thread.sleep(1000);
        reports = driver.findElement(By.cssSelector(".site-menu-arrow"));
        aggreagateReport = driver.findElement(By.cssSelector("a[href=\"/reports/campaign-aggregates\"]"));
        dateRangeReport = driver.findElement(By.cssSelector("a[href=\"/reports/date-range\"]"));
    }
    public void openAggregateReport(WebDriver chrome) {
        reports.click();
        aggreagateReport.click();

    }
    public void openDateReport(WebDriver chrome){
        reports.click();
        dateRangeReport.click();
    }
}
