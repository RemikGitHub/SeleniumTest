package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Action;
import utility.Wait;

public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[3]/div/button[2]")
    private WebElement acceptCookies;

    @FindBy(linkText = "POCZTA")
    private WebElement post;

    @FindBy(id = "ol-widget-login-button")
    private WebElement logInBtn;

    @FindBy(css = "[alt=\"avatar\"]")
    private WebElement userAvatar;

    public Home acceptCookies() {
        Action.click(acceptCookies);

        return this;
    }

    public EmailSignIn openLogInToEmailPage() {
        Action.click(post);

        return new EmailSignIn();
    }

    public OneLoginSignIn openSignInUsingOneLogin() {
        Action.click(logInBtn);

        return new OneLoginSignIn();
    }

    public boolean userIsLoggedIn() {
        Wait.waitToBeVisible(userAvatar);

        return userAvatar.isDisplayed();
    }

}
