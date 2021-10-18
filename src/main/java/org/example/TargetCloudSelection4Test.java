package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TargetCloudSelection4Test  {

    public static final String BS_USERNAME = "akshaykumar_tSifZ0";
    public static final String BS_AUTOMATE_KEY = "REJRdWCVSf38nMyrczQV";
    public static final String BS_URL = "https://" + BS_USERNAME + ":" + BS_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String SL_USERNAME = "oauth-akshaykumarreddy786-ecbe5";
    public static final String SL_ACCESS_KEY = "93a2337b-a370-44ec-8639-c4ea3f85ccf6";
    public static final String SL_URL = "https://oauth-akshaykumarreddy786-ecbe5:93a2337b-a370-44ec-8639-c4ea3f85ccf6@ondemand.us-west-1.saucelabs.com:443/wd/hub";
    public static final String LT_USERNAME = "akshaykumarreddy786";
    public static final String LT_ACCESS_KEY = "P5RzXTnhXjCaMG3JD8VO0wx70CWhjA1us8TMdMrfN1yqrLAhaL";
    public static final String LT_URL = "@hub.lambdatest.com/wd/hub";

    public static String getBrowserStackUrl() {
        System.out.println("BrowserStack cloud login url: " + BS_URL);
        return BS_URL;
    }

    public static String getSauceLabsUrl() {
        return SL_URL;
    }

    public static String getLambdaTestUrl() {
        return LT_URL;
    }

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
        return caps;
    }








}
