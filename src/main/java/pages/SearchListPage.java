package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchListPage extends BasePage {
    public SearchListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'goods-tile__inner']")
    private List<WebElement> listOfProduct;

    public void findFirstProductInList() {
        waitVisibilityOfElement(20,listOfProduct.stream().findFirst().get());
        listOfProduct.stream().findFirst().get().click();
    }
}
