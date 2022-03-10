package pageObjects;

import org.openqa.selenium.WebElement;
import utils.WebElementsLocator;

public class PaymentPage {

    public void  selectPaymentMethodAndConfirm(){
        WebElement mpesaPayOnDelivery = WebElementsLocator.getWebElement("xpath", "//label[contains(text(),'M-PESA On Delivery')]");
        mpesaPayOnDelivery.click();

        WebElement confirmOrder = WebElementsLocator.getWebElement("xpath", "//span[contains(text(),'Confirm Order')]");
        confirmOrder.click();
    }
}
