package rozetka;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;

public class RozetkaTests extends BaseTest {

    @Test
    public void checkWrongEmailError() {
        homePage.openCatalog();
        homePage.openAsusNoteBookCatalog();
        searchListPage.findFirstProductInList();
        productPage.clickOnBuyButton();
        productPage.clickOnToOrderButton();
        basketPage.fillPaymentDetails("дцвйзщ", "іуацойцза", "Львів", "0006910164");
        Assert.assertEquals(basketPage.checkErrorMessage(),"Введите номер мобильного телефона");
    }

    @Test
    public void checkContactNumbers(){
        homePage.openTabAbout();
        aboutPage.clickOnNavigationToolBar();
        aboutPage.getContactNumbers();
        Assert.assertEquals(aboutPage.getContactNumbers(), Arrays.asList("044 537 02 22","044 503 80 80","044 502 10 79","044 364 83 65","044 502 31 07"));
    }
    @Test
    public void checkTheBasketIsEmpty(){
        homePage.openCatalog();
        homePage.openAsusNoteBookCatalog();
        searchListPage.findFirstProductInList();
        productPage.clickOnBuyButton();
        productPage.clickOnContextMenuButtonByDel();
        productPage.clickOnButtonDeleteFromTheCart();
        productPage.getMessageBasketIsEmpty();
        Assert.assertEquals(productPage.getMessageBasketIsEmpty(),"Корзина пуста");
    }
}
