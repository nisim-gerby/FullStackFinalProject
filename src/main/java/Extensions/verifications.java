package Extensions;

import Utilities.commonOps;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import static org.testng.Assert.*;
public class verifications extends commonOps
{
    @Step("Verify text in element")
    public static void textInElement(WebElement elem,String expectedValue)
    {
        if(!getData("PlatfromName").equalsIgnoreCase("mobile"))
            wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(),expectedValue);

    }
//    public static void searchAndAssertElement(WebElement search,WebElement searchBtn,WebElement product, String expectedValue)
//    {
//        search.click();
//        search.sendKeys("Nikon D5500 DSLR");
//        searchBtn.click();
//        assertEquals(product.getText(),expectedValue);
//    }
    @Step("verify the number of elements equals to")
    public static void numberOfElements(List <WebElement> elems, int expectedValue)
    {
        if(!getData("PlatfromName").equalsIgnoreCase("mobile"))
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        assertEquals(elems.size(),expectedValue);
    }
    @Step("verify element visualy")
    public static void visualElement(WebElement imageElement, String expectedImageName)
    {
        BufferedImage expectedImage=null;
        try
        {
            expectedImage = ImageIO.read(new File(getData("imageRepo")+ expectedImageName+ ".png"));
        }
        catch (Exception e)
        {
            System.out.println("Error  reading image file, see details: "+ e);
        }
        Screenshot imageScreenShot = new AShot().takeScreenshot(driver,imageElement);
        BufferedImage actualImage= imageScreenShot.getImage();
        diff =imageDiff.makeDiff(actualImage,expectedImage);
        assertFalse(diff.hasDiff(), "Images are not the same");
    }
    @Step("verify text with text")
    public static void verifyText(String actualText, String expectedText)
    {
        assertEquals(actualText,expectedText);
    }

}
