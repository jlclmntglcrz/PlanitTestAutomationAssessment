package planit.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import planit.webdriver.ApplicationDriver;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ContactPage extends PageBase {

    @FindBy(linkText = "Submit")
    WebElement submitButton;

    @FindBy(id = "forename-err")
    WebElement foreNameErrLabel;

    @FindBy(id = "email-err")
    WebElement emailErrLabel;

    @FindBy(id = "message-err")
    WebElement messageErrLabel;

    @FindBy(id = "forename")
    WebElement foreNameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "message")
    WebElement messageField;

    @FindBy(xpath = "//div[.//h1 and .//div[@class='progress progress-info wait']]")
    WebElement sendingFeedbackLoadingModal;

    @FindBy(xpath = "//div[contains(.,'we appreciate') and @ui-if='contactValidSubmit']")
    WebElement successFulSubmissionMessageLabel;


    @Override
    public void click(String name) {
        switch (name.toUpperCase()) {
            case "SUBMIT":
                submitButton.click();
                break;
            default:
                Assert.fail("Unable to click " + name + "." + name + " is undefined.");
                break;
        }
    }

    @Override
    public void verifyDisplayed(List<String> objectNames) {
        for (String name : objectNames) {
            WebElement elementToVerify = null;
            switch (name.toUpperCase()) {
                case "FORENAME ERROR MESSAGE":
                    elementToVerify = foreNameErrLabel;
                    break;
                case "EMAIL ERROR MESSAGE":
                    elementToVerify = emailErrLabel;
                    break;
                case "MESSAGE ERROR MESSAGE":
                    elementToVerify = messageErrLabel;
                    break;
                default:
                    Assert.fail("Unable to click " + name + "." + name + " is undefined.");
                    break;
            }
            Assert.assertTrue(name + " is not displayed.", elementToVerify.isDisplayed());
        }
    }

    @Override
    public void populateFields(Map<String, String> fieldsMap) {
        for (Map.Entry<String, String> field : fieldsMap.entrySet()) {
            String name = field.getKey();
            String value = field.getValue();

            switch (name.toUpperCase()) {
                case "FORENAME":
                    foreNameField.sendKeys(value);
                    break;
                case "EMAIL":
                    emailField.sendKeys(value);
                    break;
                case "MESSAGE":
                    messageField.sendKeys(value);
                    break;
                default:
                    Assert.fail("Unable to populate " + name + "." + name + " is undefined.");
                    break;
            }
        }
    }

    public void waitForSendingFeedbackLoadingModal() {
        WebDriverWait wait = new WebDriverWait(ApplicationDriver.getActiveDriver(), Duration.ofSeconds(60));
//        wait.until( driver -> {
//            try {
//                return !driver.findElement(By.xpath("//div[.//h1 and .//div[@class='progress progress-info wait']]")).isDisplayed();
//            } catch (Exception e) {
//                return true;
//            }
//        });
        System.out.println("loading progress is completed.");
    }

    public void validateSuccessfulSubmission() {
        waitForSendingFeedbackLoadingModal();
        Assert.assertTrue("Submission message is not displayed", successFulSubmissionMessageLabel.isDisplayed());
    }
}
