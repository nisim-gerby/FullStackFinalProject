package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class cellPhoneMainPage
{
    @FindBy(xpath = "//div[@class=\"item-box\"]")
    public List <WebElement> btn_cellphones;
}
