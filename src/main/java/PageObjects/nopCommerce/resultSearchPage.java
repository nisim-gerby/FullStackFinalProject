package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultSearchPage
{
    @FindBy(xpath = "//h2/a")
    public WebElement txt_nikon_D5500_Dslr;

    @FindBy(xpath = "//form[@action=\"/search\"]/input[@id='small-searchterms']")
    public WebElement btn_sendKeysSearch;

    @FindBy(xpath = "//input[@class=\"button-1 search-box-button\"]")
    public WebElement btn_search;
}
