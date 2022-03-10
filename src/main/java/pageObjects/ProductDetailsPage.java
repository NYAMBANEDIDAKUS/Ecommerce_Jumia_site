package pageObjects;

import Handlers.PageActionsHandler;
import org.openqa.selenium.WebElement;
import utils.WebElementsLocator;

public class ProductDetailsPage {


    public static void productAvailableOnProductPage(String product){

        IndexPage.searchProduct(product);

        WebElement productImage = WebElementsLocator.getWebElement("xpath", "//article[1]//a[1]//div[1]//img[1]");

        PageActionsHandler.hoverOnElement(productImage);

    }


    public static  void addProductToCart(String product){

        productAvailableOnProductPage(product);
        PageActionsHandler.wait(10);
        WebElement productImage = WebElementsLocator.getWebElement("xpath", "//article[1]//a[1]//div[1]//img[1]");
        productImage.click();
        //adding product to cart

        WebElement addToCart = WebElementsLocator.getWebElement("xpath", "//form[@id='add-to-cart']//button[@name='action']");
        addToCart.click();

        //clicking cart icon
        PageActionsHandler.wait(5);
        WebElement cart = WebElementsLocator.getWebElement("xpath", "//span[@id='ci']//*[local-name()='svg']");
        cart.click();

    }
}
