package com.asheer.pages;

import com.asheer.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private final WebDriver driver;

    private final By email =
            By.id("email");

    private final By password =
            By.id("password");

    private final By signIn =
            By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){

        this.driver = driver;

    }

    public void enterEmail(String text){

        WebElement box =
                WaitUtils.getWait(driver)
                        .until(ExpectedConditions
                                .visibilityOfElementLocated(email));

        box.clear();

        box.sendKeys(text);

    }

    public void enterPassword(String text){

        WebElement box =
                WaitUtils.getWait(driver)
                        .until(ExpectedConditions
                                .visibilityOfElementLocated(password));

        box.clear();

        box.sendKeys(text);

    }

    public void clickLogin(){

        WaitUtils.getWait(driver)
                .until(ExpectedConditions
                        .elementToBeClickable(signIn))
                .click();

    }

}