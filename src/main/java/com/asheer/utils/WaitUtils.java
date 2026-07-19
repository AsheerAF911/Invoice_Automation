package com.asheer.utils;

import com.asheer.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebDriverWait getWait(WebDriver driver){

        int seconds = Integer.parseInt(
                ConfigReader.get("explicit.wait"));

        return new WebDriverWait(driver,
                Duration.ofSeconds(seconds));

    }

}