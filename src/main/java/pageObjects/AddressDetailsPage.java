package pageObjects;

import Handlers.PageActionsHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WebElementsLocator;

public class AddressDetailsPage {

    public static void fillAddressDetails(String firstname, String lastname, String phoneNum, String deliveryAdd, String region, String cityS){
        PageActionsHandler.wait(5);
        WebElement firstName = WebElementsLocator.getWebElement("xpath", "//input[@id='ShippingAddressForm_first_name']");
        PageActionsHandler.wait(1);
        firstName.sendKeys(firstname);
        WebElement lastName = WebElementsLocator.getWebElement("xpath", "//input[@id='ShippingAddressForm_last_name']");
        PageActionsHandler.wait(1);
        lastName.sendKeys(lastname);
        WebElement phoneNumber = WebElementsLocator.getWebElement("xpath", "//input[@id='ShippingAddressForm_phone']");
        PageActionsHandler.wait(1);
        phoneNumber.sendKeys(phoneNum);
        WebElement deliveryAddress = WebElementsLocator.getWebElement("xpath", "//textarea[@id='ShippingAddressForm_address1']");
        PageActionsHandler.wait(1);
        deliveryAddress.sendKeys(deliveryAdd);
        Select state = new Select(WebElementsLocator.getWebElement("xpath", "//select[@id='ShippingAddressForm_fk_customer_address_region']"));
        PageActionsHandler.wait(1);
        state.selectByVisibleText(region);
        Select city = new Select(WebElementsLocator.getWebElement("xpath", "//select[@id='ShippingAddressForm_fk_customer_address_city']"));
        PageActionsHandler.wait(1);
        city.selectByVisibleText(cityS);

        WebElement saveAndContinue =  WebElementsLocator.getWebElement("xpath","//button[@id='osh-opc-btn-save-address-shipping']");
        PageActionsHandler.wait(1);
        saveAndContinue.click();
    }
}
