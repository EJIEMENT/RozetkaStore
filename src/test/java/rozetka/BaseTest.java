package rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected HomePage homePage;
    protected PayAndDeliveryPage payAndDeliveryPage;
    protected BasketPage basketPage;
    protected SearchListPage searchListPage;
    protected ProductPage productPage;
    protected AboutPage aboutPage;

    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String ROZETKA_COM_UA = "https://rozetka.com.ua/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.0.105:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().get(ROZETKA_COM_UA);
        homePage = new HomePage(getDriver());
        payAndDeliveryPage = new PayAndDeliveryPage(getDriver());
        basketPage = new BasketPage(getDriver());
        searchListPage = new SearchListPage(getDriver());
        productPage = new ProductPage(getDriver());
        aboutPage = new AboutPage(getDriver());

    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

}