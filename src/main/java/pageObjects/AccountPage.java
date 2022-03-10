package pageObjects;

import Handlers.PageActionsHandler;
import org.openqa.selenium.WebElement;
import utils.WebElementsLocator;

public class AccountPage {

    public static  void  login(){
        WebElement emailInput = WebElementsLocator.getWebElement("xpath", "//input[@id='fi-email']");
        PageActionsHandler.wait(3);
        emailInput.sendKeys("testingwdg803@outlook.com");

        WebElement passwordInput = WebElementsLocator.getWebElement("xpath", "//input[@id='fi-password']");
        PageActionsHandler.wait(2);
        passwordInput.sendKeys("Welcome@123");

        WebElement loginButton = WebElementsLocator.getWebElement("xpath", "//button[@class='btn _prim _i -mts']");
        loginButton.click();
    }
}
