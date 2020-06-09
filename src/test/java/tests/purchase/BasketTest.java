package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

        if (browser.isElementDisplayed(mainPage.closeAnnouncementPopUp)){
            mainPage.closeAnnouncementPopUp.click();
        }

        if (browser.isElementDisplayed(categoryPage.cookieDismissButton)){
            categoryPage.cookieDismissButton.click();
        }

        //browser.waitAndClick(categoryPage.cookieDismissButton);

        clearBasket();

        browser.waitAndClick(mainPage.babyToyMenu);

        browser.waitAndClick(categoryPage.bezButton);

        browser.waitAndClick(categoryPage.primaButton);

        browser.waitAndClick(categoryPage.orderButton);

        browser.waitAndClick(categoryPage.ascendingPriceOrder);

        browser.waitAndClick(categoryPage.sizeButton);

        String itemPrice = categoryPage.prices.get(0).getText();
        String [] splittedPrice = itemPrice.split(" ");
        Double basePrice = Double.valueOf(splittedPrice[0].replace(",", "."));

        Double finalPrice = basePrice;

        browser.waitAndClick(categoryPage.addItemToBasket);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
            finalPrice = finalPrice + basePrice;
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        browser.waitAndClick(basketPage.closePopUp);

        String finalPriceString = basketPage.basketTotal.getText();
        String [] splittedFinalPrice = finalPriceString.split(" ");
        Double finalBasketPrice = Double.valueOf(splittedFinalPrice[0].replace(",", "."));

        if(finalPrice.equals(finalBasketPrice)){
            System.out.println("PRICES ARE SAME");

            //TODO fix this.
            Actions action = new Actions(browser);
            action.moveToElement(basketPage.bagButton).click();

            browser.waitAndClick(basketPage.approveBasket);

            browser.loginWait(7000);

            System.out.println("Test is done");
            Assert.assertEquals(finalPrice, finalBasketPrice);
        }
        else {
            System.out.println("PRICES ARE NOT SAME");
            Assert.assertEquals(finalPrice, finalBasketPrice);
            // fail the test.
        }

    }
}
