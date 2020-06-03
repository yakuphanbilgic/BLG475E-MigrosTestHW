package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import tests.AbstractTest;
import utils.SmsReceiver;

public class BasketTest extends AbstractTest
{
    /*
    @Test
    public void testBasketItem()
    {
        login(context.getInternalProps().getPhoneNumber());
        clearBasket();

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChichkenMenu);

        browser.waitAndClick(mainPage.meatCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.cookieDismissButton);
        browser.waitAndClick(categoryPage.addBasket);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.purchaseNote);
        browser.waitAndSendKeys(basketPage.inputNote, "120 gramlık paketler şeklinde hazırlanmasını istiyorum");

        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket);

        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
    }
    */

    @Test
    public void testBez(){
        MainPage mainPage = new MainPage(browser);
        CategoryPage categoryPage = new CategoryPage(browser);
        BasketPage basketPage = new BasketPage(browser);

        login(context.getInternalProps().getPhoneNumber());

        browser.waitAndClick(mainPage.closeAnnouncementPopUp);

        clearBasket();

        browser.waitAndClick(mainPage.babyToyMenu);

        browser.waitAndClick(categoryPage.cookieDismissButton);

        browser.waitAndClick(categoryPage.bezButton);

        browser.waitAndClick(categoryPage.primaButton);

        browser.waitAndClick(categoryPage.orderButton);

        browser.waitAndClick(categoryPage.ascendingPriceOrder);

        browser.waitAndClick(categoryPage.sizeButton);

        String itemPrice = categoryPage.prices.get(0).getText();

        browser.waitAndClick(categoryPage.addItemToBasket);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
            itemPrice += itemPrice;
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        browser.waitAndClick(basketPage.closePopUp);

        if(itemPrice.equals(basketPage.basketTotal.getText())){
            System.out.println("PRICES ARE SAME");
            browser.waitAndClick(basketPage.bagButton);
            browser.waitAndClick(basketPage.approveBasket);
            Assert.assertEquals(itemPrice, basketPage.basketTotal.getText());
        }
        else {
            System.out.println("PRICES ARE NOT SAME");
            Assert.assertEquals(itemPrice, basketPage.basketTotal.getText());
            // fail the test.
        }

    }
}
