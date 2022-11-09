package planit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Map;

public class ShopPage extends PageBase {


    public void buyToys(Map<String, String> toyMap) {
        toyMap.entrySet().stream().forEach(toy -> {
            String toyName = toy.getKey();
            Integer toyCount = Integer.parseInt(toy.getValue());
            WebElement buyButton = driver.findElement(By.xpath("//li[contains(@id,'product') and .//h4[text()='" + toyName + "']]//a[text()='Buy']"));
            for (int i = 0; i < toyCount; i++) {
                buyButton.click();
            }
        });
    }
}
