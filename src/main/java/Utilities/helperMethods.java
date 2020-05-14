package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.File;

public class helperMethods extends commonOps
{
    public static void takeElementScreenShot(WebElement imageElement, String imageNAme)
    {
       // imageScreenShot = new AShot().coordsProvider(new WebDriverCoordsProvider().takeScreenshot(driver, imageElement)); //win10
        imageScreenShot = new AShot().takeScreenshot(driver, imageElement); //win7
        try
        {
        ImageIO.write(imageScreenShot.getImage(),"png",new File(getData("imageRepo") + imageNAme + ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error writing image file, see details" + e);
        }

    }
}
