package WorkFlow;

import Extensions.uiActions;
import Utilities.commonOps;
import io.qameta.allure.Step;

public class webFlows extends commonOps
{
    @Step("login nopcommerce Flow")
    public static void login(String user, String pass)
    {
        uiActions.click(nopCommerce_Login.btn_LogInButton);
        uiActions.updateText(nopCommerce_Login.txt_Email,user);
        uiActions.updateText(nopCommerce_Login.txt_Password,pass);
        uiActions.click(nopCommerce_Login.btn_LogInButton_two);
    }
    public static void searchProduct(String productToSearch)
    {
       uiActions.click(nopCommerce_searchProduct.btn_sendKeysSearch);
       uiActions.updateText(nopCommerce_searchProduct.btn_sendKeysSearch,productToSearch);
       uiActions.click(nopCommerce_searchProduct.btn_search);
    }
}
