package Utilities;

import org.openqa.selenium.support.PageFactory;

public class managePages extends base
{
    public static void init()
    {
        nopCommerce_Login = PageFactory.initElements(driver, PageObjects.nopCommerce.login.class);
        nopCommerce_main = PageFactory.initElements(driver, PageObjects.nopCommerce.mainPage.class);
        nopCommerce_searchProduct = PageFactory.initElements(driver, PageObjects.nopCommerce.resultSearchPage.class);
        nopCommerce_ElectronicsMenu = PageFactory.initElements(driver, PageObjects.nopCommerce.electronicsMenuPage.class);
        nopCommerce_cellPhonesMenu = PageFactory.initElements(driver, PageObjects.nopCommerce.cellPhonesElectronicsMenuPage.class);
        nopCommerce_cellPhonesMainPage = PageFactory.initElements(driver, PageObjects.nopCommerce.cellPhoneMainPage.class);

        mortgageMain= PageFactory.initElements(driver, PageObjects.mortgag.mainPage.class);
    }
}

