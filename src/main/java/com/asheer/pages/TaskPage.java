package com.asheer.pages;

import com.asheer.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TaskPage {

    private final WebDriver driver;

    private final By startTask =
            By.cssSelector("a[href^='/task-form/']");

    public TaskPage(WebDriver driver) {
        this.driver = driver;
    }

    public void startTask() {

        WebElement link = WaitUtils.getWait(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(startTask));

        String taskUrl = link.getAttribute("href");

        driver.get(taskUrl);

        WaitUtils.getWait(driver)
                .until(ExpectedConditions.urlContains("/task-form/"));

        System.out.println(driver.getCurrentUrl());
    }
}