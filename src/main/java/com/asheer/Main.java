package com.asheer;

import com.asheer.config.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.getDriver();

        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        DriverFactory.quitDriver();
    }
}