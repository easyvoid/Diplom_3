package site.nomoreparties.stellarburgers.ChromeBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ExitButtonTest extends BaseTest {

    @Before
    public void setUp() {
        client.registerUser(user);

        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushLoginButton();
        loginUser(user.getEmail(), user.getPassword());
    }

    @Test
    public void exitButtonTest() {
        HomePage homePage = page(HomePage.class);
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        homePage.loginButton.should(disappear);
        accountProfilePage.waitAndPushExitButton();
        webdriver().shouldHave(url(loginPageURL));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(800);
        client.deleteUser(user);
    }
}
