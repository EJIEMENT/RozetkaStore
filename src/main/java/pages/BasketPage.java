package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
    @FindBy(xpath = "//div[@class = 'form__row js-name']//input[@formcontrolname = 'name']")
    public WebElement nameField;
    @FindBy(xpath = "//div[@class = 'form__row js-surname']//input[@formcontrolname = 'surname']")
    public WebElement surNameField;
    @FindBy(xpath = "//div[@class = 'form__row js-phone validation_type_error']//input[@formcontrolname = 'phone']")
    public WebElement phoneField;
    @FindBy(xpath = "//div[@class ='form__row js-phone validation_type_error'] //form-error//p")
    public WebElement errorMessage;

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillPaymentDetails(String name, String surname, String city, String phoneNumber) {
        nameField.sendKeys(name);
        surNameField.sendKeys(surname);
        phoneField.sendKeys(phoneNumber);
    }

    public String checkErrorMessage() {
        return errorMessage.getText();
    }
}
