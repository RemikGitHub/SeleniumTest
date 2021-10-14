package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.Home;

public class EmailSignInTest extends TestConfig {

    @Test
    public void signInToEmailWithInvalidDataShouldFail() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .submitFormWithInvalidUsernameAndPassword()
                        .userSeeErrorAlert()
        );

    }

    @Test
    public void signInToEmailWithValidDataShouldPass() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openLogInToEmailPage()
                        .submitFormWithValidUsernameAndPassword()
                        .userIsLoggedIn()
        );

    }

}
