package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class LoginPage extends AbstractPage
{
    public LoginPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    public WebElement inputPhoneNumber;

    @FindBy(id = "membership-modal-login-button")
    public WebElement loginButton;

    @FindBy(css = "#header-sticky > div.container.h-web-container.visible-md-block.visible-lg-block > div > div.col-sm-4.col-md-4.header-sticky-col-right > div > div.col-sm-5.member-col > div > div > a > span")
    public WebElement displayName;

    @FindBy(id = "otp-error-message")
    public WebElement errorMessage;
}

