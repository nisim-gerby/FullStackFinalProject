package SanityTest;

import Extensions.uiActions;
import Extensions.verifications;
import Utilities.commonOps;
import WorkFlow.webFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//----------------------------------------------------------------------------------------------
//allure report - click on the "terminal" label > write the command: allure serve allure-results
/*to get new report for every test that you running you need to quit allure report server
- click on "ctrl+c" and write the cmd from the first note
*/
//----------------------------------------------------------------------------------------------

@Listeners(Utilities.listeners.class)
public class nopCommerceWeb extends commonOps
{
    @Test(description = "test01: verify if the title is correct ")
    @Description("Test description: verify the title of the page")
    public void test01_verifyTitle()
    {
        verifications.textInElement(nopCommerce_main.txt_mainHeading, "Welcome to our store");
    }
    @Test(description = "test02: login to the web application")
    @Description("Test description: login to the NopCommerce web application")
    public void test02_login()
    {
        webFlows.login(getData("nopCommerce_email"),getData("nopCommerce_password"));
    }

    @Test(description = "test03: check the product existence")
    @Description("Test description: searching the product in the application")
    public void test03_checkProductExistent()
    {
        webFlows.searchProduct("Nikon D5500 DSLR");
        verifications.textInElement(nopCommerce_searchProduct.txt_nikon_D5500_Dslr,"Nikon D5500 DSLR");
    }
    @Test(description = "test04: check the number of products")
    @Description("Test description: check the number of products in the page")
    public void test04_checkTheNumberOfCellPhones() throws InterruptedException
    {
        uiActions.mouseHoverElements(nopCommerce_ElectronicsMenu.btn_Electronics,nopCommerce_cellPhonesMenu.btn_cellPhones);

        verifications.numberOfElements(nopCommerce_cellPhonesMainPage.btn_cellphones,3);
    }
    @Test(description = "test05: verify logo")
    @Description("Test description: verify nopcommerce logo")
    public void test05_verifyLogo() throws InterruptedException
    {
        verifications.visualElement(nopCommerce_main.img_logo,"nopCommerce logo");
    }
}
