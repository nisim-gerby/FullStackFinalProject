package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class cellPhonesElectronicsMenuPage
{
    @FindBy(xpath = "//ul[@class=\"sublist first-level\"]//a[@href=\"/camera-photo\"]")
    public WebElement btn_cameraAndPhoto;

    @FindBy(xpath = "//ul[@class=\"sublist first-level\"]//a[@href=\"/cell-phones\"]")
    public WebElement btn_cellPhones;

    @FindBy(xpath = "//ul[@class=\"sublist first-level\"]//a[@href=\"/others\"]")
    public WebElement btn_others ;
}
