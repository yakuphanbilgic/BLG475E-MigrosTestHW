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

    @FindBy(id = "phoneNumber")
    public WebElement inputPhoneNumber;

    @FindBy(id = "membership-modal-login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header-sticky\"]/div[1]/div/div[3]/div/div/div/div/a/span")
    public WebElement displayName;

    @FindBy(id = "otp-error-message")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"sendAgainOtpPass\"]")
    public WebElement sendAgainDisabledButton;

    @FindBy(xpath = "//*[@id=\"otp-progress\"]/span")
    public WebElement loginProgressBar;
}

