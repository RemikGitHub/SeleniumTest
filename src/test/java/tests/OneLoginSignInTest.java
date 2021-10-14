package tests;

import config.TestConfig;
import org.junit.Assert;
import org.junit.Test;
import pages.Home;

public class OneLoginSignInTest extends TestConfig {

    @Test
    public void signInToOneLoginWithInvalidDataShouldFail() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openSignInUsingOneLogin()
                        .submitFormWithInvalidUsernameAndPassword()
                        .userSeeErrorAlert()
        );

    }

    @Test
    public void signInToOneLoginWithValidDataShouldPass() {
        Assert.assertTrue(
                new Home()
                        .acceptCookies()
                        .openSignInUsingOneLogin()
                        .submitFormWithValidUsernameAndPassword()
                        .userIsLoggedIn()
        );

    }
}
