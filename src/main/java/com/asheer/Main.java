package com.asheer;

import com.asheer.config.ConfigReader;
import com.asheer.config.DriverFactory;
import com.asheer.models.Invoice;
import com.asheer.pages.LoginPage;
import com.asheer.pages.DashboardPage;
import com.asheer.pages.TaskFormPage;
import com.asheer.pages.TaskPage;
import org.openqa.selenium.WebDriver;

public class Main {

    public static void main(String[] args)
            throws Exception {

        WebDriver driver = DriverFactory.getDriver();

        driver.get(ConfigReader.get("base.url"));

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );

        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.get("https://www.careersconnectindia.com/tasks");

        Thread.sleep(10000);

        System.out.println(driver.getCurrentUrl());

        DashboardPage dashboard =
                new DashboardPage(driver);

        dashboard.openTaskManagement();

        TaskPage taskPage = new TaskPage(driver);

        taskPage.startTask();

        Invoice invoice = new Invoice();
        
        invoice.setEstimateRequestId("ORD90187735");
        invoice.setCustomerAddress("Main Colony");
        invoice.setEstimateDate("19/07/2026");
        invoice.setCustomerId("CUS000026");
        invoice.setEstimateNumber("EST000026");
        invoice.setProductName("SSD Drive");
        invoice.setProductType("Storage");
        invoice.setProductQuantity("6");
        invoice.setUnitPrice("7160");
        invoice.setProductDescription("Test Description");
        invoice.setProductHighlights("Test Highlights");
        invoice.setDiscount("14");
        invoice.setTaxableAmount("36916");
        invoice.setGst("12");
        invoice.setTotalEstimatedAmount("41345");
        invoice.setAmountInWords("Forty One Thousand Three Hundred Forty Five");
        invoice.setAdvancePaymentRequired("16041");
        invoice.setPaymentTerms("Net 20");
        invoice.setBalanceAmount("25304");
        invoice.setEstimateValidTill("18/08/2026");

        TaskFormPage taskForm = new TaskFormPage(driver);
        taskForm.fillForm(invoice);

        System.out.println(driver.getCurrentUrl());

        Thread.sleep(10000);

        DriverFactory.quitDriver();

    }

}