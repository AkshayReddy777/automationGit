package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JavaScriptAndScreenShotClass {


    public static void main (String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://zodha.wavo.co/login");
//        WebElement we=driver.findElement(By.xpath("//*[@name=\"email\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='Test';", we);
        js.executeScript("document.querySelector('input[name=\"email\"]').value='madhoo@zodha.com';" +
                "document.querySelector('input[name=\"password\"]').value='123123Aa@';" +
                "document.getElementsByTagName('button')[0].click();");
//        js.executeScript("document.querySelector('input[name=\"password\"]').value='123123Aa@';");
//        js.executeScript("document.getElementsByTagName('button')[0].click();");

        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot , new File("C:\\Users\\Admin\\Desktop\\JavaScreenShots\\LoginScreenshot.png"));

    }

}
