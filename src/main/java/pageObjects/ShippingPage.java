package pageObjects;

import Handlers.PageActionsHandler;
import Handlers.mainHandler;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.WebElementsLocator;

public class ShippingPage{

    public static void selectDeliveryMethod(String deliveryMethod){

        WebElement pickUpStation = WebElementsLocator.getWebElement("xpath", "//label[contains(text(),'Pickup Station')]");
        WebElement homeOrOffice = WebElementsLocator.getWebElement("xpath", "//label[contains(text(),'Delivery to your home or office')]");
        PageActionsHandler.wait(5);
        if(deliveryMethod.equalsIgnoreCase("Pickup station")){
            PageActionsHandler.wait(5);
            pickUpStation.click();
            PageActionsHandler.wait(10);
            WebElement pickUpStationForm= WebElementsLocator.getWebElement("xpath","pus-popup-form");
            if (pickUpStationForm.isDisplayed()){
                    Select region = new Select(WebElementsLocator.getWebElement("xpath", "//select[@id='PickupStationForm_fk_pickupstation_customer_address_region']"));
                    region.selectByVisibleText("Nairobi");
                    Select city =  new Select(WebElementsLocator.getWebElement("xpath", "//select[@id='PickupStationForm_fk_pickupstation_customer_address_city']"));
                    city.selectByVisibleText("karen");
                    //select station
                    WebElement station = WebElementsLocator.getWebElement("xpath","/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/form[1]/div[5]/div[1]/label[1]");
                    station.click();

                    WebElement saveStationButton = WebElementsLocator.getWebElement("xpath", "//button[@class='osh-btn -full-width js-pus-proceed']");
                    saveStationButton.click();
            }else{
                mainHandler.logger.fail("Error! form not displayed");
            }

        }else if(deliveryMethod.equalsIgnoreCase("home")){

                homeOrOffice.click();
        }else if(deliveryMethod.equalsIgnoreCase("office")){
                homeOrOffice.click();
        }else{
            mainHandler.logger.fail("invalid delivery method");
        }

        WebElement saveAndProceedButton = WebElementsLocator.getWebElement("id", "osh-opc-btn-save");
        saveAndProceedButton.click();
    }
}
