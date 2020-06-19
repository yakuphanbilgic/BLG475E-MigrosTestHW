package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.purchase.BasketPage;
import pages.user.LoginPage;
import utils.Browser;
import utils.TestContext;

public class AbstractTest
{
    public static TestContext context = new TestContext();
    public static Browser browser = context.doCreateBrowser();
    Double threshold = 60.00;
    MainPage mainPage = new MainPage(browser);
    CategoryPage categoryPage = new CategoryPage(browser);
    BasketPage basketPage = new BasketPage(browser);


    @BeforeClass
    public static void setUpClass()
    {
        browser.get("https://www.migros.com.tr");
    }

    @AfterClass
    public static void tearDownClass()
    {
        if (null != browser)
            browser.quit();
    }

    public void login(String username)
    {
        browser.waitAndClick(mainPage.loginButton);

        LoginPage loginPage = new LoginPage(browser);

        browser.waitAndSendKeys(loginPage.inputPhoneNumber, username);

        browser.waitAndClick(loginPage.loginButton);

        checkTekrarGonderButtonDisabled();

        browser.loginWait(30000);

        Assert.assertNotNull(loginPage.displayName.getText());
    }

    public void clearBasket()
    {
        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.trashButton))
        {
            browser.waitAndClick(mainPage.trashButton);
        }

        browser.waitAndClick(mainPage.shoppingBasketButton);
    }

    public void selectPrimaSizeFourAndOrder()
    {
        browser.waitAndClick(mainPage.babyToyMenu);

        browser.waitAndClick(categoryPage.bezButton);

        browser.waitAndClick(categoryPage.primaButton);

        browser.waitAndClick(categoryPage.orderButton);

        browser.waitAndClick(categoryPage.ascendingPriceOrder);

        browser.waitAndClick(categoryPage.sizeButton);
    }

    public void successfulProceedToBasket(String price)
    {

        String itemPrice = price;
        String [] splitPrice = itemPrice.split(" ");
        Double basePrice = Double.valueOf(splitPrice[0].replace(",", "."));

        Double finalPrice = basePrice;

        browser.waitAndClick(categoryPage.addItemToBasket);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        finalPrice = checkProgressBarIfPriceIsBiggerThanThreshold(finalPrice, basePrice);

        browser.waitAndClick(mainPage.goToBasketButton);

        if(basketPage.closePopUp.isDisplayed()){
            browser.waitAndClick(basketPage.closePopUp);
        }

        String finalPriceString = basketPage.basketTotal.getText();
        String [] splitFinalPrice = finalPriceString.split(" ");
        Double finalBasketPrice = Double.valueOf(splitFinalPrice[0].replace(",", "."));

        checkApproveBasketButtonIfPriceIsSmallerThanThreshold(finalBasketPrice);

        if(finalPrice.equals(finalBasketPrice)){
            //TODO fix this.
            Actions action = new Actions(browser);
            action.moveToElement(basketPage.bagButton).click();

            browser.waitAndClick(basketPage.approveBasket);

            browser.loginWait(25000);

            System.out.println("Test is done");
            Assert.assertEquals(finalPrice, finalBasketPrice);
        }
        else {
            System.out.println("PRICES ARE NOT SAME");
            Assert.assertEquals(finalPrice, finalBasketPrice);
        }
    }

    public void checkApproveBasketButtonIfPriceIsSmallerThanThreshold(Double finalBasketPrice)
    {
        if(finalBasketPrice < threshold ){
            Assert.assertTrue(!basketPage.approveBasket.isEnabled());
        }
    }

    public double checkProgressBarIfPriceIsBiggerThanThreshold(Double finalPrice, Double basePrice)
    {
        //Check progress bar
        Double temp = 0.00;
        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
            finalPrice = finalPrice + basePrice;
            if(finalPrice >= threshold)
            {
                if(browser.isElementDisplayed(mainPage.progressBarText)){
                    System.out.println("Progress bar should not be displayed.");
                    Assert.assertEquals(finalPrice, temp);
                }
            }
        }
        return finalPrice;
    }

    public void checkTekrarGonderButtonDisabled()
    {
        /*If time progress bar button is not 0:00, tekrar gonder should be disabled
         * If it is 0:00, login button should completely disappear*/
        LoginPage loginPage = new LoginPage(browser);

        String time = loginPage.loginProgressBar.getText();

        if(!time.equals("0:00")){
            Assert.assertTrue(loginPage.sendAgainDisabledButton.isEnabled());
        }
    }

    public void closeCookieAndPopups()
    {
        if (browser.isElementDisplayed(mainPage.closeAnnouncementPopUp)){
            mainPage.closeAnnouncementPopUp.click();
        }

        if (browser.isElementDisplayed(categoryPage.cookieDismissButton)){
            categoryPage.cookieDismissButton.click();
        }
    }
}
