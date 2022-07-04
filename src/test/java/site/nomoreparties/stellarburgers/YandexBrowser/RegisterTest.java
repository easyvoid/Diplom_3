package site.nomoreparties.stellarburgers.YandexBrowser;

import api.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class RegisterTest extends YandexBaseTest {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);
    }

    @Test
    public void registerPositiveTest() {
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister(user.getName(), user.getEmail(), user.getPassword());

        webdriver().shouldHave(url(loginPageURL));
    }

    @Test
    public void registerShortPasswordTest() {
        User userWithShortPassword = new User(user.getEmail(), gen.randomShortPassword(), user.getName());
        HomePage homePage = open(homePageURL, HomePage.class);
        LoginPage loginPage = homePage.waitAndPushLoginButton();

        RegisterPage registerPage = loginPage.waitAndPushRegisterLink();

        registerPage.fullRegister(userWithShortPassword.getName(), userWithShortPassword.getEmail(), userWithShortPassword.getPassword());

        registerPage.passwordErrorVisible();

        user = userWithShortPassword;
    }

    @After
    public void tearDown() throws InterruptedException {
        String body = client.loginUser(user).and().extract().body().path("accessToken");
        Thread.sleep(800);
        if (body != null) {
            client.deleteUser(user);
        }
        driver.quit();
    }
}