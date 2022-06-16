package site.nomoreparties.stellarburgers.ChromeBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class AccountProfileTest extends BaseTest {

    @Before
    public void setUp(){
        client.registerUser(user);
    }

    @Test
    public void pushAccountButtonNotAuthTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url(loginPageURL));
    }

    @Test
    public void pushAccountButtonAuthTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushLoginButton();
        loginUser(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        homePage.waitAndPushAccountButton();
        webdriver().shouldHave(url(profilePageURL));
    }

    @After
    public void tearDown() throws InterruptedException {
        client.deleteUser(user);
        Thread.sleep(800);
    }
}