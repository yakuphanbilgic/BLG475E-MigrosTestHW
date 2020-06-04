package pages.purchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

import java.util.List;

public class BasketPage extends AbstractPage
{
    public BasketPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(id = "cloth-bag-input")
    public WebElement bagButton;

    @FindBy(id = "summaryRevenue")
    public WebElement basketTotal;

    @FindBy(id = "in-cart-next-button")
    public WebElement approveBasket;

    //This might not work as intended
    @FindBy(css = "#cartCampaignModal > div > div > div.modal-header > button")
    public WebElement closePopUp;
}