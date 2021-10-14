package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Action;
import utility.DataFaker;
import utility.Wait;

public class OneLoginSignIn extends BasePage {

    private final DataFaker faker;

    public OneLoginSignIn() {
        super();
        faker = new DataFaker();
    }

    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(css = "[data-testid=\"login-error\"]")
    private WebElement alert;

    private void fillInUsernameAndPassword() {
        Action.sendKeys(loginInput, faker.getEmail());
        Action.sendKeys(passwordInput, faker.getPassword());
    }

    private void fillInUsernameAndPassword(String username, String password) {
        Action.sendKeys(loginInput, username);
        Action.sendKeys(passwordInput, password);
    }

    public OneLoginSignIn submitFormWithInvalidUsernameAndPassword() {

        fillInUsernameAndPassword();
        Action.click(signInButton);

        return this;
    }

    public Home submitFormWithValidUsernameAndPassword() {

        fillInUsernameAndPassword("domino_jachas_1234@wp.pl", "qwER12#$");
        Action.click(signInButton);

        return new Home();
    }

    public boolean userSeeErrorAlert() {
        String expectedAlert = "Nieprawidłowy adres e‑mail lub hasło.";
        Wait.waitToBeVisible(alert);

        return alert.getText().equals(expectedAlert);
    }

}
