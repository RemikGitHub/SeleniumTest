package pages;

import config.WebDriverSingleton;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverSingleton.getInstance(), this);
    }
}
