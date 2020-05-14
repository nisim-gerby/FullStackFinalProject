package Utilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class commonOps extends base
{
    public static String getData(String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try
        {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e)
        {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBroswer(String braswerType)
    {
        if (braswerType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (braswerType.equalsIgnoreCase("FireFox"))
            driver = initFFDriver();
        else if (braswerType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else
            throw new RuntimeException(("invalid platform name stated"));

        driver.manage().window().maximize();
        driver.get(getData("url"));
        action = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("timeOut")));


    }

    public static WebDriver initChromeDriver()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFFDriver()
    {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver()
    {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }
    public static void initMobile()
    {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,getData("APP_ACTIVITY"));
        try
        {
            driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), dc);
        } catch (Exception e)
        {
            System.out.println("can not connect appium server, see details: "+ e);
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("timeOut")), TimeUnit.SECONDS);

    }

    public static void initApi()
    {
        RestAssured.baseURI= getData("url_api");
        httpRequest = RestAssured.given().auth().preemptive().basic(getData("grafana_user"),getData("grafana_password"));
    }
    public static void initElectron()
    {
        System.setProperty("webdriver.chrome.driver",getData("Electron_driver_path")));
    }


        @BeforeClass
    public void startSession()
    {

        if (getData("PlatfromName").equalsIgnoreCase("web"))
            initBroswer(getData("BroswerName"));
        else if(getData("PlatfromName").equalsIgnoreCase("mobile"))
            initMobile();
        else if(getData("PlatfromName").equalsIgnoreCase("api"))
            initApi();
        else if(getData("PlatfromName").equalsIgnoreCase("electron"))
            initElectron();
        else
            throw new RuntimeException(("invalid platform name stated"));
        managePages.init();
    }

    @AfterMethod
    public void afterMethod()
    {   if (getData("PlatfromName").equalsIgnoreCase("web"))
            driver.get(getData("url"));
    }

    @AfterClass
    public void closeSession()
    {
        if (!getData("PlatfromName").equalsIgnoreCase("api"))
        driver.quit();
    }
}
