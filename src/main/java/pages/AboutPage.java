package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class AboutPage extends BasketPage {
    @FindBy(xpath = "//nav[@class = 'rz-static-navigation']")
    private List<WebElement> navigationToolBar;
    @FindBy(xpath = "//a[@class = 'rz-chips__button' and @href = 'https://rozetka.com.ua/contacts/']")
    private WebElement contactTab;
    @FindBy(xpath = "//a[@class = 'contacts-main__number ng-star-inserted']")
    private List<WebElement> contactNumbers;


    public AboutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnNavigationToolBar() {
        waitVisibilityOfElement(20,contactTab);
        contactTab.click();
    }

    public List<String> getContactNumbers() {
        List<String> stringList = contactNumbers.stream().map(WebElement::getText).collect(Collectors.toList());
        return stringList;
    }

}
