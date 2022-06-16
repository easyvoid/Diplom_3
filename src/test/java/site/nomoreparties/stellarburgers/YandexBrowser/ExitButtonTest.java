package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.*;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class ExitButtonTest extends BaseTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

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
        driver.quit();
        client.deleteUser(user);
        Thread.sleep(800);
    }
}
