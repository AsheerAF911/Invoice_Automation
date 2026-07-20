package com.asheer.pages;

import com.asheer.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {

    private final WebDriver driver;

    private final By taskManagement =
            By.cssSelector("a[href='/tasks']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openTaskManagement() {

        WebElement taskTab = WaitUtils.getWait(driver)
                .until(ExpectedConditions.presenceOfElementLocated(taskManagement));

        // Scroll into view
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", taskTab);

        // JavaScript click
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", taskTab);

        // Wait until the page is opened
        WaitUtils.getWait(driver)
                .until(ExpectedConditions.urlContains("/tasks"));

        System.out.println("Task page opened successfully.");
    }
}