package SanityTest;

import Extensions.verifications;
import Utilities.commonOps;
import WorkFlow.mobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Utilities.listeners.class)
public class mortgageMobile extends commonOps
{
    @Test(description = "test01: verify mortgage ")
    @Description("Test description: Fill in mortgage fields and calculate repayment")
    public void test01_verifyMortgage()
    {
        mobileFlows.calculate("1000","3","4");
        verifications.textInElement(mortgageMain.txt_repayment,"￡30.03");
    }
}
