package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class electronicsMenuPage
{
    @FindBy(xpath = "//ul[@class=\"top-menu notmobile\"]//a[@href=\"/electronics\"]")
    public WebElement btn_Electronics;
}
