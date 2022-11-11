package planit.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import planit.utilities.TestConfiguration;

import java.lang.reflect.Method;
import java.time.Duration;

public class EventListener implements WebDriverListener {


    @Override
    public void beforeAnyWebElementCall(WebElement element, Method method, Object[] args) {
        WebDriverWait wait = new WebDriverWait(ApplicationDriver.getActiveDriver(), Duration.ofSeconds(TestConfiguration.getDefaultWaitDuratation()));
        wait.until(ExpectedConditions.jsReturnsValue("if (document.readyState === 'complete') { return true; }"));
    }

    @Override
    public void beforeClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ApplicationDriver.getActiveDriver(), Duration.ofSeconds(TestConfiguration.getDefaultWaitDuratation()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(ApplicationDriver.getActiveDriver());
        actions.moveToElement(element);
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        WebDriverWait wait = new WebDriverWait(ApplicationDriver.getActiveDriver(), Duration.ofSeconds(TestConfiguration.getDefaultWaitDuratation()));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Actions actions = new Actions(ApplicationDriver.getActiveDriver());
        actions.moveToElement(element);
    }


}
