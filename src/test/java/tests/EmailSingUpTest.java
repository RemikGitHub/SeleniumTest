package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.Home;

public class EmailSingUpTest extends TestConfig {

    @Test
    public void signUpToEmailWithMismatchesPasswords() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .openSignUpPage()
                        .submitRegistrationFormWithMismatchedPasswords()
                        .userSeeErrorAlertWithText("Hasła nie są identyczne.")
        );
    }

    @Test
    public void signUpToEmailWithoutChoosingGender() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .openSignUpPage()
                        .submitRegistrationFormWithoutChoosingGender()
                        .userSeeErrorAlertWithText("Proszę wybrać płeć.")
        );
    }

    @Test
    public void signUpToEmailWithTooShortPassword() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .openSignUpPage()
                        .submitRegistrationFormWithToShortPassword()
                        .userSeeErrorAlertWithText("Minimalna długość hasła to 8 znaków.")
        );
    }

    @Test
    public void signUpToEmailWithExistingLogin() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .openSignUpPage()
                        .submitRegistrationFormExistingLogin()
                        .userSeeErrorAlertWithText("Podany login jest niedostępny.")
        );
    }

    @Test
    public void signUpToEmailWithoutChoosingTypeOfAccount() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .openSignUpPage()
                        .submitRegistrationFormWithoutChoosingTypeOfAccount()
                        .userSeeErrorAlertWithText("Wybierz typ konta.")
        );
    }
}
