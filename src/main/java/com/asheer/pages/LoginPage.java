package com.asheer.pages;

import com.asheer.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    private final WebDriver driver;

    private final By email = By.id("email");
    private final By password = By.id("password");
    private final By signIn = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private void enterEmail(String text) {

        WebElement box = WaitUtils.getWait(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(email));

        box.clear();
        box.sendKeys(text);
    }

    private void enterPassword(String text) {

        WebElement box = WaitUtils.getWait(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(password));

        box.clear();
        box.sendKeys(text);
    }

    private void clickLogin() {

        WebElement button = WaitUtils.getWait(driver)
                .until(ExpectedConditions.elementToBeClickable(signIn));

        button.click();

        // Wait until the clicked button is removed or refreshed
        WaitUtils.getWait(driver)
                .until(ExpectedConditions.stalenessOf(button));

        System.out.println("Login request submitted");
    }

    public void login(String email, String password) {

        enterEmail(email);
        enterPassword(password);
        clickLogin();

        WaitUtils.getWait(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("a[href='/tasks']")));

        System.out.println("Login Successful");
        System.out.println(driver.getCurrentUrl());
    }
}