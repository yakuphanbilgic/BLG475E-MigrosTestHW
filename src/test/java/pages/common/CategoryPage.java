package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class CategoryPage extends AbstractPage
{
    public CategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;

    @FindBy(css = "//*[@id=\"product-list\"]/div[2]/div[1]/div/form/div[2]/div[3]/button")
    public WebElement addBasket;

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement bezButton;

    @FindBy(className = "sort-label--others")
    public WebElement orderButton;

    @FindBy(linkText = "Önce En Yüksek Fiyat")
    public WebElement ascendingPriceOrder;

    @FindBy(xpath = "//*[@id=\"page-area\"]/div/div/div[1]/div[1]/div/div[3]/ul/li/ul/li[1]/a")
    public WebElement primaButton;

    @FindBy(xpath = "//*[@id=\"page-area\"]/div/div/div[1]/div[1]/div/div[4]/ul/li/ul/li[5]/a/div")
    public WebElement sizeButton;
}
