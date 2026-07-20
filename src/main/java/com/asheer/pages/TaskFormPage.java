package com.asheer.pages;

import com.asheer.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.asheer.models.Invoice;

public class TaskFormPage {

    private final WebDriver driver;

    public TaskFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By estimateRequestId = By.id("estimateRequestId");
    private final By customerAddress = By.id("customerAddress");
    private final By estimateDate = By.id("estimateDate");
    private final By customerId = By.id("customerId");
    private final By estimateNumber = By.id("estimateNumber");
    private final By productName = By.id("productName");
    private final By productType = By.id("productType");
    private final By productQuantity = By.id("productQuantity");
    private final By unitPrice = By.id("unitPrice");
    private final By productDescription = By.id("productDescription");
    private final By productHighlights = By.id("productHighlights");
    private final By discount = By.id("discount");
    private final By taxableAmount = By.id("taxableAmount");
    private final By gst = By.id("gst");
    private final By totalEstimatedAmount = By.id("totalEstimatedAmount");
    private final By amountInWords = By.id("amountInWords");
    private final By advancePaymentRequired = By.id("advancePaymentRequired");
    private final By paymentTerms = By.id("paymentTerms");
    private final By balanceAmount = By.id("balanceAmount");
    private final By estimateValidTill = By.id("estimateValidTill");

    // Generic typing method
    private void type(By locator, String value) {

        WebElement box = WaitUtils.getWait(driver)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

        box.clear();

        // Slow typing because this website misses characters
        for (char c : value.toCharArray()) {
            box.sendKeys(String.valueOf(c));

            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /*public void setEstimateRequestId(String value) {
        type(estimateRequestId, value);
    }

    public void setCustomerAddress(String value) {
        type(customerAddress, value);
    }

    public void setEstimateDate(String value) {
        type(estimateDate, value);
    }

    public void setCustomerId(String value) {
        type(customerId, value);
    }

    public void setEstimateNumber(String value) {
        type(estimateNumber, value);
    }

    public void setProductName(String value) {
        type(productName, value);
    }

    public void setProductType(String value) {
        type(productType, value);
    }

    public void setProductQuantity(String value) {
        type(productQuantity, value);
    }

    public void setUnitPrice(String value) {
        type(unitPrice, value);
    }

    public void setProductDescription(String value) {
        type(productDescription, value);
    }

    public void setProductHighlights(String value) {
        type(productHighlights, value);
    }

    public void setDiscount(String value) {
        type(discount, value);
    }

    public void setTaxableAmount(String value) {
        type(taxableAmount, value);
    }

    public void setGST(String value) {
        type(gst, value);
    }

    public void setTotalEstimatedAmount(String value) {
        type(totalEstimatedAmount, value);
    }

    public void setAmountInWords(String value) {
        type(amountInWords, value);
    }

    public void setAdvancePaymentRequired(String value) {
        type(advancePaymentRequired, value);
    }

    public void setPaymentTerms(String value) {
        type(paymentTerms, value);
    }

    public void setBalanceAmount(String value) {
        type(balanceAmount, value);
    }

    public void setEstimateValidTill(String value) {
        type(estimateValidTill, value);
    }*/

    public void fillForm(Invoice invoice) {

        System.out.println("Inside fillForm()");

        type(estimateRequestId, invoice.getEstimateRequestId());
        type(customerAddress, invoice.getCustomerAddress());
        type(estimateDate, invoice.getEstimateDate());
        type(customerId, invoice.getCustomerId());
        type(estimateNumber, invoice.getEstimateNumber());
        type(productName, invoice.getProductName());
        type(productType, invoice.getProductType());
        type(productQuantity, invoice.getProductQuantity());
        type(unitPrice, invoice.getUnitPrice());
        type(productDescription, invoice.getProductDescription());
        type(productHighlights, invoice.getProductHighlights());
        type(discount, invoice.getDiscount());
        type(taxableAmount, invoice.getTaxableAmount());
        type(gst, invoice.getGst());
        type(totalEstimatedAmount, invoice.getTotalEstimatedAmount());
        type(amountInWords, invoice.getAmountInWords());
        type(advancePaymentRequired, invoice.getAdvancePaymentRequired());
        type(paymentTerms, invoice.getPaymentTerms());
        type(balanceAmount, invoice.getBalanceAmount());
        type(estimateValidTill, invoice.getEstimateValidTill());
    }
}