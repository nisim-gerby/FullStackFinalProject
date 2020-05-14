package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class uiActions extends commonOps
{   @Step("click on element")
    public static void click(WebElement elem)
    {   if(!getData("PlatfromName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("update the text")
    public static void updateText(WebElement elem, String value)
    {
        if(!getData("PlatfromName").equalsIgnoreCase("mobile"))
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }
    @Step("update Drop Down")
    public static void updateDropDown(WebElement elem, String value)
    {
        Select myValue=new Select(elem);
        myValue.selectByVisibleText(value);
    }
    @Step("mouse Hover Elements")
    public static void mouseHoverElements(WebElement elem1,WebElement elem2)
    {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }
}
