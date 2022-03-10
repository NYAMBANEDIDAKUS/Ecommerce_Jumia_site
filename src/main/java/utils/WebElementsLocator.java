package utils;

import Handlers.mainHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementsLocator extends mainHandler {
    public static   WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "xpath":
                return driver.findElement(By.xpath(identifierValue));
            case "css":
                return driver.findElement(By.cssSelector(identifierValue));
            case "tagName":
                return driver.findElement(By.tagName(identifierValue));
            case "id":
                return driver.findElement(By.id(identifierValue));
            case "name":
                return driver.findElement(By.name(identifierValue));
            default:
                return null;
        }
    }
        public List<WebElement> getWebElements(String identifierType, String identifierValue){
            switch (identifierType){
                case "xpath":
                    return mainHandler.driver.findElements(By.xpath(identifierValue));
                case "css":
                    return mainHandler.driver.findElements(By.cssSelector(identifierValue));
                case "tagName":
                    return mainHandler.driver.findElements(By.tagName(identifierValue));
                case "id":
                    return mainHandler.driver.findElements(By.id(identifierValue));
                default:
                    return null;
            }

    }
}
