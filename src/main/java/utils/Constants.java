package utils;

import java.io.File;

public interface Constants {
    String PRODUCT = "Hifinit 32 Inch Frameless Digital HD Ready LED TV - Black";
    String CHROME_DRIVERS = System.getProperty("user.dir") + File.separator +"drivers" + File.separator + "chromedriver.exe";
    String FIREFOX_DRIVER = System.getProperty("user.dir") + File.separator + "drivers" +File.separator + "gecko.exe";
    String REPORT_SORE = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Jumia_test_reports.html";
    String CONFIGURATION_FILEPATH = System.getProperty("user.dir") + File.separator + "Configurations" + File.separator +"Configurations.properties";
    int IMPLICIT_WAIT_TIME = 10;
    int EXPLICIT_TIME_WAIT = 10;
}
