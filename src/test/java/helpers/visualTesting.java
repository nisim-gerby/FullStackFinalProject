package helpers;

import PageObjects.nopCommerce.mainPage;
import Utilities.commonOps;
import Utilities.helperMethods;
import org.testng.annotations.Test;

public class visualTesting extends commonOps
{
    @Test
    public void createScreenShot()
    {
        helperMethods.takeElementScreenShot(nopCommerce_main.img_logo,"nopCommerce logo_ver1.00");
    }
}
