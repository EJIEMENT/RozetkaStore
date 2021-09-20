package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[contains(@href, '/producer=asus/')]")
    private WebElement asusNoteBookProduct;
    @FindBy(id = "fat-menu")
    private WebElement catalog;
    @FindBy(xpath = "//input[@name = 'search']")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class = 'search-form__back']")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@href = 'https://rozetka.com.ua/pages/about/']")
    private WebElement linkToTabAbout;
    @FindBy(xpath = "//div[@class= 'menu-wrapper menu-wrapper_state_animated']")
    private WebElement categories;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void searchProduct(String productName) {
        searchInput.sendKeys(productName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", searchButton);
    }

    public void openCatalog() {
        catalog.click();
    }

    public void openAsusNoteBookCatalog() {
        waitForAttribute(10, categories, "style", "display: block;");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", asusNoteBookProduct);
    }

    public void openTabAbout() {
        linkToTabAbout.click();
    }

}
