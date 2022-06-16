package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.*;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class AccountProfileTest extends BaseTest {
    ChromeDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        client.registerUser(user);
    }

    @After
    public void tearDown() throws InterruptedException {
        driver.quit();
        client.deleteUser(user);
        Thread.sleep(800);
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
}