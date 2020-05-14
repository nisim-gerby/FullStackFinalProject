package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class mainPage
{
    @FindBy(xpath = "//div[@class='topic-block-title']/h2")
    public WebElement txt_mainHeading;

    @FindBy(xpath = "//img[@src='//demo.nopcommerce.com/Themes/DefaultClean/Content/images/logo.png']")
    public WebElement img_logo;
}

