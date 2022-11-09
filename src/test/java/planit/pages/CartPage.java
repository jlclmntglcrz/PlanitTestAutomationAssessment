package planit.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class CartPage extends PageBase {

    @FindBy(xpath = "//tr/td//*[contains(text(),'Total:')]")
    WebElement totalLabel;

    public void verifyProductSubtotal(Map<String, String> productMap) {
        productMap.entrySet().stream().forEach(product -> {
            String productName = product.getKey();
            String productSubTotal = product.getValue();
            try {
                WebElement validSubTotalLabel = driver.findElement(By.xpath("//tr[./td[normalize-space(text())='" + productName + "']]//td[text()='" + productSubTotal + "']"));
                Assert.assertTrue(productName + " with subtotal of " + productSubTotal + " is not displayed", validSubTotalLabel.isDisplayed());
            } catch (NoSuchElementException e) {
                Assert.fail(productName + " with subtotal of " + productSubTotal + " is not displayed");
            }
        });
    }

    public void verifyProductPrice(Map<String, String> productMap) {
        productMap.entrySet().stream().forEach(product -> {
            String productName = product.getKey();
            String productPrice = product.getValue();
            try {
                WebElement validSubTotalLabel = driver.findElement(By.xpath("//tr[./td[normalize-space(text())='" + productName + "']]//td[text()='" + productPrice + "']"));
                Assert.assertTrue(productName + " with price of " + productPrice + " is not displayed", validSubTotalLabel.isDisplayed());
            } catch (NoSuchElementException e) {
                Assert.fail(productName + " with price of " + productPrice + " is not displayed");
            }
        });
    }


    public void verifyTotal(String value) {
        String actualTotal = totalLabel.getText().replace("Total:", "").trim();
        Assert.assertTrue("", actualTotal.contentEquals(value));
    }

}
