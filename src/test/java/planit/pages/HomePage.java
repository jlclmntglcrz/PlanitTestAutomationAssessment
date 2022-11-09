package planit.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageBase {

    @FindBy(id = "nav-contact")
    WebElement contactNavButton;

    @FindBy(id = "nav-shop")
    WebElement shopNavButton;
    @FindBy(id = "nav-cart")
    WebElement cartNavButton;

    @Override
    public void click(String name) {
        switch (name.toUpperCase()) {
            case "CONTACT":
                contactNavButton.click();
                break;
            case "SHOP":
                shopNavButton.click();
                break;
            case "CART":
                cartNavButton.click();
                break;
            default:
                Assert.fail("Unable to click " + name + "." + name + " is undefined.");
                break;
        }
    }

}
