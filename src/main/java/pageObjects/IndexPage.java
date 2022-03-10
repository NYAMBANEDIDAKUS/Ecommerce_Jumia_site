package pageObjects;

import Handlers.PageActionsHandler;
import Handlers.mainHandler;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebElementsLocator;

public class IndexPage extends  mainHandler{
    //alert box
    static WebElement ALERT_CLOSE = WebElementsLocator.getWebElement("xpath", "//body/div[@id='jm']/div[@id='pop']/div[1]/section[1]/button[1]/*[1]");
    //search bar
    static WebElement searchBar = WebElementsLocator.getWebElement("name", "q");
    static WebElement searchButton = WebElementsLocator.getWebElement("xpath", "//button[contains(text(),'Search')]");
    //categories side pane elements
    static WebElement supermarket = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Supermarket')]");
    static WebElement healthAndBeauty = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Health & Beauty')]");
    static WebElement homeOffice = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Home & Office')]");
    static WebElement phonesTablet = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Phones & Tablets')]");
    static WebElement computing = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Computing')]");
    static WebElement electronics = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Fashion')]");
    static WebElement fashion = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Supermarket')]");
    static WebElement gaming = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Gaming')]");
    static WebElement babyProducts = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Baby Products')]");
    static WebElement sportingGoods = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Sporting Goods')]");
    static WebElement gardenAndOutdoors = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Garden & Outdoors')]");
    static WebElement otherCategories = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Other categories')]");

    public static void closeSubscriptionAlert(){
        PageActionsHandler.wait(5);
        mainHandler.logger.info("finding subscription modal");
        PageActionsHandler.clickElement(ALERT_CLOSE);

    }
    public static void searchProduct(String product){

        logger.info("Entering text "+ product);
        PageActionsHandler.sendText(searchBar, product);
        logger.info("Clicking Search button");
        PageActionsHandler.wait(3);
        PageActionsHandler.waitTillElementIsClickable(searchButton);
        PageActionsHandler.clickElement(searchButton);
    }

    public  static  void categoriesSidePane(){
        logger.info("Validating categories pane");
        logger.info("Checking supermarket under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(supermarket);
        PageActionsHandler.wait(1);
        logger.info("Checking Health & Beauty under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(healthAndBeauty);
        logger.info("Checking home & office under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(homeOffice);
        logger.info("Checking Phone & Tablet under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(phonesTablet);
        logger.info("Checking computing under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(computing);
        logger.info("Checking Electronics under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(electronics);
        logger.info("Checking Fashion under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(fashion);
        logger.info("Checking Gaming under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(gaming);
        logger.info("Checking Baby Products under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(babyProducts);
        logger.info("Checking Sporting Goods under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(sportingGoods);
        logger.info("Checking Gardens & Outdoors under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(supermarket);
        logger.info("Checking Other categories under categories");
        PageActionsHandler.wait(1);
        Assert.assertNotNull(otherCategories);
    }

}
