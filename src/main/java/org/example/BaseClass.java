package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class BaseClass {
    protected WebDriver driver;
    protected WebElement textField;



    public BaseClass(WebDriver driver) {
        this.driver = driver;



    }

    public WebElement textFieldSetter(String s) {

        textField =driver.findElement(By.cssSelector(s));
        return textField;

    }

}
