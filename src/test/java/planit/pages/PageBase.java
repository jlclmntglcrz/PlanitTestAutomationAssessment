package planit.pages;

import io.cucumber.java.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import planit.webdriver.ApplicationDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class PageBase {

    PageBase() {
        driver = ApplicationDriver.getActiveDriver();
        PageFactory.initElements(driver, this);
    }

    public static WebDriver driver;

    public static PageBase getPage(String pageName) {
        switch (pageName.toUpperCase()) {
            case "HOME":
                return new HomePage();
            case "CONTACT":
                return new ContactPage();
            default:
                return null;
        }
    }


    public void click(String name) {
    }

    public void populateFields(Map<String, String> fieldsMap) {
    }

    public void verifyDisplayed(List<String> objectNames) {
    }

    public void verifyNotDisplayed(List<String> objectNames) {
    }


}
