package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        client.registerUser(user);
    }

    @Test
    public void loginButtonTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        webdriver().shouldHave(url(loginPageURL));
        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginWithAccountButtonTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        homePage.waitAndPushAccountButton();

        webdriver().shouldHave(url(loginPageURL));
        LoginPage loginPage = page(LoginPage.class);

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginFromRegisterPageTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        webdriver().shouldHave(url(loginPageURL));
        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();
        webdriver().shouldHave(url(registerPageURL));
        registerPage.waitAndPushLoginButton();
        webdriver().shouldHave(url(loginPageURL));

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @Test
    public void loginFromForgotPasswordPageTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();
        ForgotPasswordPage forgotPasswordPage = loginPage.waitAndPushForgotPasswordLink();
        forgotPasswordPage.waitAndPushLoginButton();

        loginPage.fullLogin(user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(homePageURL));

        String actualEmail = checkAccountProfile();
        assertEquals(user.getEmail(),actualEmail);
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        Thread.sleep(800);
        client.deleteUser(user);
    }
}