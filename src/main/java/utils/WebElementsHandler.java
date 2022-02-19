package utils;

import mainHandler.Handler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebElementsHandler {
    public static  WebElement getWebElement(String identfierType, String identfierValue) {
        switch (identfierType) {
            case "xpath":
                return Handler.driver.findElement(By.xpath(identfierValue));
            case "css":
                return Handler.driver.findElement(By.cssSelector(identfierValue));
            case "tagName":
                return Handler.driver.findElement(By.tagName(identfierValue));
            case "id":
                return Handler.driver.findElement(By.id(identfierValue));
            default:
                return null;
        }
    }
        public static  List<WebElement> getWebElements(String identfierType, String identfierValue){
            switch (identfierType){
                case "xpath":
                    return Handler.driver.findElements(By.xpath(identfierValue));
                case "css":
                    return Handler.driver.findElements(By.cssSelector(identfierValue));
                case "tagName":
                    return Handler.driver.findElements(By.tagName(identfierValue));
                case "id":
                    return Handler.driver.findElements(By.id(identfierValue));
                default:
                    return null;
            }

    }
}
