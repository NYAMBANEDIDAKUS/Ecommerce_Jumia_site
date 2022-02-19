package pageEvents;

import pageObjects.HomePageElements;
import utils.WebElementsHandler;

public class HomePageEvents {

    public static  void verifyJumiaOpens(){
        WebElementsHandler.getWebElement("xpath", HomePageElements.header).click();
    }

}
