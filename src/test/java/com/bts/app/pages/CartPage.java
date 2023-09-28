package com.bts.app.pages;

import com.bts.app.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;


public class CartPage {

    private WebDriver driver;
    private WaitHelper wait;

    private By cartTableSelector = By.xpath("//*[contains(@class, 'table table-striped cart-items')]");
    private By TotalSelector = By.xpath("//*[contains(@class, 'total')]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }



    // Method to calculate the subtotal for a specific product
    public void calculateSubtotalForEachProduct(){
        wait = new WaitHelper(driver);
        wait.waitForElementsList(cartTableSelector);
        WebElement table = driver.findElement(By.xpath("//*[contains(@class, 'table table-striped cart-items')]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size() -2; i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));

            Double productPrice = Double.parseDouble(columns.get(1).getText().replace("$",""));
            Double subtotal = Double.parseDouble(columns.get(3).getText().replace("$",""));
            WebElement quantityInput = columns.get(2).findElement(By.tagName("input"));
            String quantityValue = quantityInput.getAttribute("value");
            Integer quantity = Integer.parseInt(quantityValue);

            double calculateSubTotal = productPrice * quantity;

            Assert.assertEquals((Object)subtotal,(Object)calculateSubTotal);
        }
    }

    public void calculateTotalAndSubtotalAmount() {

        double sumOfSubtotal = 0.0; //Initialize sumofsubtotal

        wait = new WaitHelper(driver);
        wait.waitForElementsList(cartTableSelector);
        WebElement table = driver.findElement(By.xpath("//*[contains(@class, 'table table-striped cart-items')]"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size() -2; i++) {
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("td"));

            Double subtotal = Double.parseDouble(columns.get(3).getText().replace("$",""));
            sumOfSubtotal += subtotal; // Add subtotal to sumofsubtotal
        }
        // Extract total from the page
        WebElement totalElement = driver.findElement(TotalSelector);
        double actualTotal = Double.parseDouble(totalElement.getText().replaceAll("[^0-9.]",""));

        // Validate the calculated sumofsubtotal matches with the actual total
        Assert.assertEquals(actualTotal,sumOfSubtotal);
    }

}
