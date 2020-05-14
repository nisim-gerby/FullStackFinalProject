package Utilities;

import io.restassured.path.json.JsonPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class base
{
    public static WebDriver driver;
    public static Actions action;
    public static WebDriverWait wait;
    public static Screenshot imageScreenShot;
    public static ImageDiffer imageDiff = new ImageDiffer();
    public static ImageDiff diff;
    public static DesiredCapabilities dc = new DesiredCapabilities();




    public static PageObjects.nopCommerce.login nopCommerce_Login;
    public static PageObjects.nopCommerce.mainPage nopCommerce_main;
    public static PageObjects.nopCommerce.resultSearchPage nopCommerce_searchProduct;
    public static PageObjects.nopCommerce.electronicsMenuPage nopCommerce_ElectronicsMenu;
    public static PageObjects.nopCommerce.cellPhonesElectronicsMenuPage nopCommerce_cellPhonesMenu;
    public static PageObjects.nopCommerce.cellPhoneMainPage nopCommerce_cellPhonesMainPage;

    public static PageObjects.mortgag.mainPage mortgageMain;
    public static RequestSpecification httpRequest;
    public static Response response;
    public static JSONObject requestParams=new JSONObject();
    public static JsonPath jp;



}

