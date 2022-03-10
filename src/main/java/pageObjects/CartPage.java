package pageObjects;

import Handlers.PageActionsHandler;
import org.openqa.selenium.WebElement;
import utils.WebElementsLocator;

public class CartPage {

    public static void increaseQuantityOfItemInCart(int itemQuantity){
        PageActionsHandler.wait(5);
        WebElement increaseQuantity = WebElementsLocator.getWebElement("xpath", "//article[@class='card-w col8 -df -d-co -pvs']//article[2]//div[1]//div[1]//form[1]//button[2]//*[local-name()='svg']");
        increaseQuantity.click();
    }

    public static void decreaseQuantityOfItemInCart(int itemQuantity){
        WebElement decreaseQuantity = WebElementsLocator.getWebElement("xpath","//article[@class='card-w col8 -df -d-co -pvs']//article[2]//div[1]//div[1]//form[1]//button[1]//*[local-name()='svg']");
        decreaseQuantity.click();
    }

    public static void removeProductFromCart(){
        WebElement removeItemButton = WebElementsLocator.getWebElement("xpath", "//body/div[@id='jm']/main/div[@class='row -pvs']/article[@class='card-w col8 -df -d-co -pvs']/div[@class='prd-w _list row']/article[2]/div[1]/div[1]/button[1]");

        removeItemButton.click();
    }

    public static void checkOutItems(){
        WebElement checkOutButton = WebElementsLocator.getWebElement("xpath", "//a[@class='btn _prim _md -fw']");
        PageActionsHandler.wait(5);
        checkOutButton.click();
    }
}
