package utility;

import config.WebDriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    static final int WAIT_TIMEOUT = 10;

    public static void waitToBeClickable(WebElement element) {
        new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitToBeVisible(WebElement element) {
        new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForTagName(String tagName) {
        new WebDriverWait(WebDriverSingleton.getInstance(), WAIT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(tagName)));
    }
}
