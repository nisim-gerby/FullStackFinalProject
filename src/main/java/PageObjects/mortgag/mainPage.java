package PageObjects.mortgag;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class mainPage
{
    @FindBy(id = "etAmount")
    public WebElement txt_amount;

    @FindBy(id = "etTerm")
    public WebElement txt_term;

    @FindBy(id = "etRate")
    public WebElement txt_rate;

    @FindBy(id = "btnCalculate")
    public WebElement btn_calculate;

    @FindBy(id = "tvRepayment")
    public WebElement txt_repayment;
}
