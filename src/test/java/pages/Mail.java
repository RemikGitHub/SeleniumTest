package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Wait;

public class Mail extends BasePage {

    public Mail() {
        super();
    }

    @FindBy(css = "[alt=\"avatar\"]")
    private WebElement userAvatar;

    
    public boolean userIsLoggedIn() {
        Wait.waitToBeVisible(userAvatar);

        return userAvatar.isDisplayed();
    }


}
