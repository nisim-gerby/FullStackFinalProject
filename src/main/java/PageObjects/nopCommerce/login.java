package PageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class login
{
    //the button named "log in" that transfer to the login page
    @FindBy(how = How.LINK_TEXT , using= "Log in")
    public WebElement btn_LogInButton;

    //Email
    @FindBy(how = How.ID , using= "Email")
    public WebElement txt_Email;
    //password
    @FindBy(how = How.ID , using= "Password")
    public WebElement txt_Password;
    //login button
    @FindBy(how= How.XPATH, using = "//div/input[@class='button-1 login-button']")
    public WebElement btn_LogInButton_two;

}
