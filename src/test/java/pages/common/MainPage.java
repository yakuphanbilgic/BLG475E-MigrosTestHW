package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class MainPage extends AbstractPage
{
    public MainPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(id = "membership-login-link")
    public WebElement loginButton;

    @FindBy(linkText = "Bebek, Oyuncak")
    public WebElement babyToyMenu;

    @FindBy(css = "#headerCartContainer > div.header-cart > div.shoping-cart-icon-block")
    public WebElement shoppingBasketButton;

    @FindBy(className = "progress-bar-text")
    public WebElement progressBarText;

    @FindBy(css = ".action-td .plus-orange")
    public WebElement plusButton;

   // @FindBy(xpath = "//*[@id=\"cart-bar\"]/div/div[2]/ul/li/form/table/tbody/tr[1]/td[5]/a/i")
    @FindBy(css = "a[data-store='20000000001078']")
    public WebElement trashButton;

    @FindBy(className = "go-to-basket-button")
    public WebElement goToBasketButton;

    @FindBy(xpath = "//*[@id=\"deliveryFromStoreAnnouncement\"]/div/div/div/button")
    public WebElement closeAnnouncementPopUp;

}
