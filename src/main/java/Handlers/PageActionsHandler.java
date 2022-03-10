package Handlers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.util.List;

public class PageActionsHandler {
    public static  Actions actions;
    public static void sendText(WebElement element, String textString){
      /*  actions = new Actions(mainHandler.driver);
        actions.sendKeys(textString).perform();*/
       element.sendKeys(textString);
    }

    public  static  void  clickElement(WebElement element){
        actions = new Actions(mainHandler.driver);
        actions.moveToElement(element).click().build().perform();
        PageActionsHandler.waitTillElementIsClickable(element);
        element.click();

    }

    public static void clickRadioOrCheckbox(List<WebElement> webElementList, String value){
        String actualValue;

        for (WebElement element : webElementList){
            actualValue = element.getAttribute("value").trim();
            if (element.isEnabled() && actualValue.equals(value)){
                element.click();
            }
        }
    }

    public static void  selectDropDown(WebElement element, String textToSelect){
        try{
            Select select = new Select(element);
            List<WebElement> elementList = select.getOptions();

            for (WebElement el : elementList){
                if (el.getText().equals(textToSelect)){
                    select.selectByVisibleText(textToSelect);
                    break;
                }
            }
        }catch (UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    public  static void selectDropDown(WebElement element ,int index){
        try {
            Select select = new Select(element);
            int size = select.getOptions().size();
            if (size > index){
                select.selectByIndex(index);
            }
        }catch(UnexpectedTagNameException e){
            e.printStackTrace();
        }
    }

    public  static  void hoverOnElement(WebElement element){
        actions = new Actions(mainHandler.driver);
        actions.moveToElement(element).build().perform();
    }
    public static WebDriverWait getWaitElement(){
        WebDriverWait wait = new WebDriverWait(mainHandler.driver, Constants.EXPLICIT_TIME_WAIT);
        return  wait;
    }
    public static  WebElement waitTillElementIsClickable(WebElement element){
        //return (WebElement) getWaitElement().until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public  static  void wait(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }



}
