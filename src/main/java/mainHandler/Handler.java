package mainHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
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

import java.io.File;
import java.lang.reflect.Method;

public class Handler {
    public static WebDriver driver;

    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static ITestResult iTestResult;
    public static String logText;
    public static String methodName;
    public  static  Markup markup;

    @BeforeTest
    public  void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "Jumia_test_reports.html");
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
    public static void beforeMethodMethod(String browserName, Method testMethod) {
        extentTest = extentReports.createTest(testMethod.getName());
        setUpDrivers(browserName);
        if (browserName.equalsIgnoreCase("chrome")) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setAcceptInsecureCerts(true);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.merge(desiredCapabilities);
            driver.get(Constants.URL);
        }

    }

    @AfterMethod
    public static void beforeMethodMethod() {
        if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            methodName = iTestResult.getMethod().getMethodName();
            logText = "Test Case" + methodName + "Passed";
            markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        } else if (iTestResult.getStatus() == ITestResult.FAILURE) {
            methodName = iTestResult.getMethod().getMethodName();
            logText = "Text Case" + methodName + "Failed";
            markup = MarkupHelper.createLabel(logText, ExtentColor.RED);

        }
        driver.quit();
    }

    @AfterTest
    public static void afterTestMethod() {
        extentReports.flush();
    }

    public static void setUpDrivers(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "gecko.exe");
            driver = new FirefoxDriver();
        }
    }
}
