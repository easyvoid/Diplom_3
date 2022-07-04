package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.HomePage;
import site.nomoreparties.stellarburgers.YandexBaseTest;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class TransitToSectionTest extends YandexBaseTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        open(homePageURL, HomePage.class);
    }

    @Test
    public void pushBunsButtonTest() {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushSaucesButton();
        homePage.currentSaucesExistAndVisible();
        homePage.waitAndPushBunsButton();

        homePage.bunsButtonDoesNotExist();
        homePage.currentBunsExistAndVisible();
    }

    @Test
    public void pushSaucesButtonTest() {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushSaucesButton();

        homePage.saucesButtonDoesNotExist();
        homePage.currentSaucesExistAndVisible();
    }

    @Test
    public void pushFillingsButtonTest() {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushFillingsButton();

        homePage.fillingsButtonDoesNotExist();
        homePage.currentFillingsExistAndVisible();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
