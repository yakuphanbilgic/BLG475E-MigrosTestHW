package tests.purchase;

import org.junit.Test;
import pages.common.CategoryPage;
import tests.AbstractTest;

public class BasketTest extends AbstractTest
{
    @Test
    public void testHomeworkScenario(){
        CategoryPage categoryPage = new CategoryPage(browser);

        login(context.getInternalProps().getPhoneNumber());

        closeCookieAndPopups();

        clearBasket();

        selectPrimaSizeFourAndOrder();

        successfulProceedToBasket(categoryPage.prices.get(0).getText());
    }
}
