package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

import java.util.List;

public class CategoryPage extends AbstractPage
{
    public CategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = ".price-tag .value")
    public List<WebElement> prices;

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;

    @FindBy(css = "#product-list > div.sub-category-product-list > div:nth-child(1) > div > form > div.product-card-bottom > div.product-card-bottom--arid > button")
    public WebElement addItemToBasket;

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement bezButton;

    @FindBy(className = "sort-label--others")
    public WebElement orderButton;

    @FindBy(linkText = "Önce En Yüksek Fiyat")
    public WebElement ascendingPriceOrder;

    @FindBy(css = "#page-area > div > div > div.col-md-2.sidebar-container-column > div.category-sidebar > div > div:nth-child(3) > ul > li > ul > li:nth-child(1) > a > div")
    public WebElement primaButton;

    @FindBy(xpath = "//*[@id=\"page-area\"]/div/div/div[1]/div[1]/div/div[4]/ul/li/ul/li[5]/a/div")
    public WebElement sizeButton;
}
