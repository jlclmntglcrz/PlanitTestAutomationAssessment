package planit.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import planit.utilities.TestConfiguration;

import java.time.Duration;

public class ApplicationDriver {

    private static ThreadLocal<WebDriver> applicationDriver = new ThreadLocal<>();

    public static WebDriver getActiveDriver() {
        return applicationDriver.get();
    }

    public static void setActiveDriverToNull() {
        applicationDriver.remove();
        ;
    }

    public static void initializeDriver() {
        if (applicationDriver.get() != null)
            return;

        WebDriverListener listener = new EventListener();

        switch (TestConfiguration.getBrowserType().toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", TestConfiguration.getChromeDriverPath());
                applicationDriver.set(new EventFiringDecorator(listener).decorate(new ChromeDriver()));
                getActiveDriver().manage().window().maximize();
                getActiveDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestConfiguration.getDefaultWaitDuratation())); //duration is usually set in configuration file
                break;
            default:
                System.out.println("browser name undefine.");
                System.exit(1);
        }
    }

    public static void quit() {
        if (applicationDriver.get() == null)
            return;

        getActiveDriver().quit();
    }


}
