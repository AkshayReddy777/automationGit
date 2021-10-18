package org.example;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BOUserLoginCreds {

    protected static Properties userLoginDetails;
    protected static String emailIDfromFile;
    protected static String passwordfromFile;
    protected static String urlfromFile;
    protected static String testAutomationWebsite;
    protected static String target;

    public static void initialize() throws IOException {

        File userloginCredsfile = new File("src/test/java/loginCredentials");
        FileInputStream fis = new FileInputStream(userloginCredsfile);
        userLoginDetails = new Properties();

        userLoginDetails.load(fis);

        emailIDfromFile = userLoginDetails.getProperty("email");
        passwordfromFile = userLoginDetails.getProperty("password");
        urlfromFile = userLoginDetails.getProperty("url");
        testAutomationWebsite = userLoginDetails.getProperty("testAutomationWebsite");


       System.out.println(emailIDfromFile);
        System.out.println(passwordfromFile);


    }

    public static String getEmailIDfromFile() {

        return emailIDfromFile;
    }

    public static String getPasswordfromFile() {
        return passwordfromFile;
    }

    public static String getUrlfromFile() {
        return urlfromFile;
    }

}
