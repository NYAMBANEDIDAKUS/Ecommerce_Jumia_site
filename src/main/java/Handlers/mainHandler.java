package Handlers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class mainHandler {
    public static WebDriver driver;

    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger;
    public static String logText;
    public static String methodName;
    public  static  Markup markup;

    @BeforeTest
    public  void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(Constants.REPORT_SORE);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Jumia Automation Report");
        htmlReporter.config().setReportName("automation test results");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("QA engineer", "Charles Ondabu");

    }

    @BeforeMethod
    @Parameters(value = {"browserName"})
    public  void beforeMethodMethod(String browserName, Method testMethod) {
        SettingsHandler.getSettings(Constants.CONFIGURATION_FILEPATH);
        logger = extentReports.createTest(testMethod.getName());
        setUpDrivers(browserName);
      if (browserName.equalsIgnoreCase("chrome")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setAcceptInsecureCerts(true);
            desiredCapabilities.setCapability("applicationCacheEnabled", false);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-minimized");
            options.merge(desiredCapabilities);
            driver.get("https://jumia.co.ke");

        }

    }

    @AfterMethod
    public void afterMethodMethod(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            methodName = iTestResult.getMethod().getMethodName();
            logText = "Test Case : " + methodName + " Passed";
            markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (iTestResult.getStatus() == ITestResult.FAILURE) {
            methodName = iTestResult.getMethod().getMethodName();
            logText = "Test Case : " + methodName + " Failed";
            markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger.log(Status.FAIL, markup);

        }

     //  driver.quit();
    }

    @AfterTest
    public  void afterTestMethod() {

        extentReports.flush();
    }

    public WebDriver setUpDrivers(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVERS);
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER);
            driver = new FirefoxDriver();

        }

        return driver;
    }
}
