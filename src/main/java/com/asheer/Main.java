package com.asheer;

import com.asheer.config.ConfigReader;
import com.asheer.config.DriverFactory;
import com.asheer.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args)
            throws Exception {

        WebDriver driver = DriverFactory.getDriver();

        driver.get(ConfigReader.get("base.url"));

        LoginPage login = new LoginPage(driver);

        login.enterEmail("larebk714@gmail.com");

        login.enterPassword("Lareb@123");

        login.clickLogin();

        Thread.sleep(10000);

        DriverFactory.quitDriver();

    }

}