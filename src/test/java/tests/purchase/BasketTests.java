package tests.purchase;

import org.junit.Test;
import pages.common.CategoryPage;
import tests.AbstractTest;

public class BasketTests extends AbstractTest
{
    /*
        First finds the required item, adds it to basket, then logins to website.
     */
    @Test
    public void firstAddToBasketThenLogin(){
        CategoryPage categoryPage = new CategoryPage(browser);

        // Close cookie and popup windows if they are displayed
        closeCookieAndPopups();

        // Select "bebek oyuncak, then prima, then size four and
        // order products with descending price order.
        selectPrimaSizeFourAndOrder();

        // Get the first item's price before adding it to the basket.
        String itemPrice = categoryPage.prices.get(0).getText();

        // Add first item to the basket.
        browser.waitAndClick(categoryPage.addItemToBasket);

        // Login window should pop up, login
        login(context.getInternalProps().getPhoneNumber());

        // Close cookie and popup windows if they are displayed after logging in.
        closeCookieAndPopups();

        // Proceed to approve basket page and check final prices and finish the test.
        successfullyProceedToBasketAfterLogin(itemPrice);
    }

    /*
        First logins, then implements the scenario in the homework.
    */
    @Test
    public void firstLoginThenAddToBasket(){
        CategoryPage categoryPage = new CategoryPage(browser);

        // Login to the website using the phone number
        login(context.getInternalProps().getPhoneNumber());

        // Close cookie and popup windows if they are displayed after logging in.
        closeCookieAndPopups();

        // Clear the previously added products from basket.
        clearBasket();

        // Select "bebek oyuncak, then prima, then size four and
        // order products with descending price order.
        selectPrimaSizeFourAndOrder();

        // Proceed to approve basket page and check final prices and finish the test.
        successfullyProceedToBasketWhileLoggedIn(categoryPage.prices.get(0).getText());
    }
}
