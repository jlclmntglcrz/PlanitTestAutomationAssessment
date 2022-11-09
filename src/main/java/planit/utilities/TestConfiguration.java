package planit.utilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TestConfiguration {

    private static final Integer WAIT_DURATION_IN_SECONDS = 60;

    private static final String BROWSER_TYPE = "chrome";
    private static final String CHROMEDRIVER_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "planit" + File.separator + "drivers" + File.separator + "chromedriver";

    public static void changeActiveDataSet(String dataSetName) {
    }

    public static String getChromeDriverPath() {
        return CHROMEDRIVER_PATH;
    }

    public static Integer getDefaultWaitDuratation() {
        return WAIT_DURATION_IN_SECONDS;
    }

    public static String getBrowserType() {
        return BROWSER_TYPE;
    }

    private static Map<String, String> dataMap = new HashMap<String, String>();

    public static String getValue(String name) {
        // will get data from yaml file, for future improvement
        dataMap.put("url", "http://jupiter.cloud.planittesting.com");
        return dataMap.get(name);
    }
}
