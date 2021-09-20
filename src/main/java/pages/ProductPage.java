package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'product-gallery__price']//span[@class = 'buy-button__label ng-star-inserted']")
    private WebElement buyButton;
    @FindBy(xpath = "//a[contains(@class, 'button button_size_large')]")
    private WebElement toOrderButton;
    @FindBy(xpath = "//img[@class = 'picture-container__picture']")
    private WebElement productImage;
    @FindBy(xpath = "//button[@class = 'button button--white button--small context-menu__toggle']")
    private WebElement contextMenuButton;
    @FindBy(xpath = "//button[contains(@class,'link context-menu-actions__button')]")
    private WebElement deleteProductFromCart;
    @FindBy(xpath = "//h4[@class = 'cart-dummy__heading']")
    private WebElement messageBasketIsEmpty;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnBuyButton() {
        productImage.click();
        buyButton.click();
    }
    public void clickOnContextMenuButtonByDel(){
        contextMenuButton.isDisplayed();
        contextMenuButton.click();
    }
    public void clickOnButtonDeleteFromTheCart(){
        deleteProductFromCart.click();
    }
    public String  getMessageBasketIsEmpty(){
        return messageBasketIsEmpty.getText();
    }

    public void clickOnToOrderButton() {
        toOrderButton.click();
    }
}
