package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utility.Action;
import utility.DataFaker;
import utility.Wait;

import java.util.ArrayList;
import java.util.List;

public class EmailSignUp extends BasePage {

    private final DataFaker faker;

    public EmailSignUp() {
        super();
        faker = new DataFaker();
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]/form/div[1]/div[1]/div/input")
    private WebElement nameInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[3]/form/div[1]/div[2]/div/input")
    private WebElement surnameInput;

    @FindBy(css = "[for=\"male\"]")
    private WebElement maleRadioBtn;

    @FindBy(css = "[for=\"female\"]")
    private WebElement femaleRadioBtn;

    @FindBy(css = "form input[name=\"day\"]")
    private WebElement dayOfBirth;

    @FindBy(css = "form select[name=\"month\"]")
    private WebElement monthOfBirth;

    @FindBy(css = "form select[name=\"year\"]")
    private WebElement yearOfBirth;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]/form/div[4]/div/div[1]/div[1]/input")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "rePassword")
    private WebElement repeatPasswordInput;

    @FindBy(css = "[name=\"recoveryPhone\"]")
    private WebElement phoneNumberInput;

    @FindBy(css = "[for=\"free\"]")
    private WebElement freeAccountRadioBtn;

    @FindBy(css = "[for=\"pro\"]")
    private WebElement paidAccountRadioBtn;

    @FindBy(css = "[for=\"selectAll\"]")
    private WebElement agreementsCheckbox;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement submitBtn;

    @FindBy(css = "form > div ul > li")
    private List<WebElement> alerts;

    private void fillInNameAndSurname(String name, String surname) {
        Action.sendKeys(nameInput, name);
        Action.sendKeys(surnameInput, surname);
    }

    private void selectGender(boolean isMale) {
        if (isMale) {
            Action.click(maleRadioBtn);
        } else {
            Action.click(femaleRadioBtn);
        }
    }

    private void fillInDateOfBirth(int day, int month, int year) {
        Action.sendKeys(dayOfBirth, Integer.toString(day));
        new Select(monthOfBirth).selectByIndex(month);
        new Select(yearOfBirth).selectByValue(Integer.toString(year));
    }

    private void fillInLogin(String login) {
        Action.sendKeys(loginInput, login);
    }

    private void fillInPasswordAndRePassword(String password, boolean theyMatch) {
        Action.sendKeys(passwordInput, password);

        if (theyMatch) {
            Action.sendKeys(repeatPasswordInput, password);
        } else {
            Action.sendKeys(repeatPasswordInput, faker.getPassword());
        }
    }

    private void fillInPhoneNumber(String phoneNumber) {
        Action.sendKeys(phoneNumberInput, phoneNumber);
    }

    private void chooseTypeOfAccount(boolean isFree) {
        if (isFree) {
            Action.click(freeAccountRadioBtn);
        } else {
            Action.click(paidAccountRadioBtn);
        }
    }

    private void checkAgreements() {
        Action.click(agreementsCheckbox);
    }


    public EmailSignUp submitRegistrationFormWithMismatchedPasswords() {

        fillInNameAndSurname(faker.getName(), faker.getSurname());
        selectGender(true);
        fillInDateOfBirth(faker.getDayOfBirth(), faker.getMonthOfBirth(), faker.getYearOfBirth());
        fillInLogin(faker.getLogin());
        fillInPasswordAndRePassword(faker.getPassword(), false);
        fillInPhoneNumber(faker.getPhoneNumber());
        chooseTypeOfAccount(true);
        checkAgreements();
        Action.click(submitBtn);

        return this;
    }

    public EmailSignUp submitRegistrationFormWithoutChoosingGender() {

        fillInNameAndSurname(faker.getName(), faker.getSurname());
        fillInDateOfBirth(faker.getDayOfBirth(), faker.getMonthOfBirth(), faker.getYearOfBirth());
        fillInLogin(faker.getLogin());
        fillInPasswordAndRePassword(faker.getPassword(), true);
        fillInPhoneNumber(faker.getPhoneNumber());
        chooseTypeOfAccount(true);
        checkAgreements();
        Action.click(submitBtn);

        return this;
    }

    public EmailSignUp submitRegistrationFormWithToShortPassword() {

        fillInNameAndSurname(faker.getName(), faker.getSurname());
        selectGender(true);
        fillInDateOfBirth(faker.getDayOfBirth(), faker.getMonthOfBirth(), faker.getYearOfBirth());
        fillInLogin(faker.getLogin());
        fillInPasswordAndRePassword(faker.getShortPassword(), true);
        fillInPhoneNumber(faker.getPhoneNumber());
        chooseTypeOfAccount(true);
        checkAgreements();
        Action.click(submitBtn);

        return this;
    }

    public EmailSignUp submitRegistrationFormExistingLogin() {

        fillInNameAndSurname(faker.getName(), faker.getSurname());
        selectGender(false);
        fillInDateOfBirth(faker.getDayOfBirth(), faker.getMonthOfBirth(), faker.getYearOfBirth());
        fillInLogin("domino_jachas_1234");
        fillInPasswordAndRePassword(faker.getPassword(), true);
        fillInPhoneNumber(faker.getPhoneNumber());
        chooseTypeOfAccount(true);
        checkAgreements();
        Action.click(submitBtn);

        return this;
    }

    public EmailSignUp submitRegistrationFormWithoutChoosingTypeOfAccount() {

        fillInNameAndSurname(faker.getName(), faker.getSurname());
        selectGender(true);
        fillInDateOfBirth(faker.getDayOfBirth(), faker.getMonthOfBirth(), faker.getYearOfBirth());
        fillInLogin(faker.getLogin());
        fillInPasswordAndRePassword(faker.getPassword(), true);
        fillInPhoneNumber(faker.getPhoneNumber());
        Action.click(submitBtn);

        return this;
    }

    public boolean userSeeErrorAlertWithText(String EXPECTED_MESSAGE) {
        Wait.waitForTagName("form > div ul > li");

        return getAlertMessageContent().contains(EXPECTED_MESSAGE);
    }

    private List<String> getAlertMessageContent() {
        List<String> alertMessages = new ArrayList<>();

        for (WebElement message : alerts) {
            alertMessages.add(message.getText());
        }

        return alertMessages;
    }


}
