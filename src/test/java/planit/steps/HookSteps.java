package planit.steps;

import io.cucumber.java.After;
import planit.webdriver.ApplicationDriver;

public class HookSteps {
    @After
    public void after() {
        ApplicationDriver.quit();
        ApplicationDriver.setActiveDriverToNull();
    }
}
