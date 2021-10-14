package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Action;
import utility.DataFaker;
import utility.Wait;

public class EmailSignIn extends BasePage {

    private final DataFaker faker;

    public EmailSignIn() {
        super();
        faker = new DataFaker();
    }

    @FindBy(id = "login")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement signInButton;

    @FindBy(xpath = "//*[text()='Podany login i/lub hasło są nieprawidłowe.']")
    private WebElement alert;

    @FindBy(css = "[href=\"https://poczta.wp.pl/rejestracja\"]")
    private WebElement createAccount;

    private void fillInUsernameAndPassword() {
        Action.sendKeys(loginInput, faker.getLogin());
        Action.sendKeys(passwordInput, faker.getPassword());
    }

    private void fillInUsernameAndPassword(String username, String password) {
        Action.sendKeys(loginInput, username);
        Action.sendKeys(passwordInput, password);
    }

    public EmailSignUp openSignUpPage() {
        Action.click(createAccount);

        return new EmailSignUp();
    }

    public EmailSignIn submitFormWithInvalidUsernameAndPassword() {
        fillInUsernameAndPassword();
        Action.click(signInButton);

        return this;
    }

    public Mail submitFormWithValidUsernameAndPassword() {
        fillInUsernameAndPassword("domino_jachas_1234", "qwER12#$");
        Action.click(signInButton);

        return new Mail();
    }

    public boolean userSeeErrorAlert() {
        String expectedAlert = "Podany login i/lub hasło są nieprawidłowe.";
        Wait.waitToBeVisible(alert);

        return alert.getText().equals(expectedAlert);
    }

}
