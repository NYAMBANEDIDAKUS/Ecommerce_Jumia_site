package pageObjects;

import Handlers.mainHandler;
import org.openqa.selenium.WebElement;
import utils.WebElementsLocator;

public class OrderConfirmationPage {

    public static  void  confirmOrder(){
        WebElement statusMessage = WebElementsLocator.getWebElement("xpath", "//h1[@class='-fs16']");

        if (statusMessage.getText().equalsIgnoreCase("Thank you for shopping with jumia")){

        }else{
            mainHandler.logger.info("Error! order not completed");
        }
    }
}
