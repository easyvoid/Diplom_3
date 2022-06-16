package site.nomoreparties.stellarburgers.YandexBrowser;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.HomePage;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;


public class TransitToSectionTest extends BaseTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        open(homePageURL, HomePage.class);
    }

    @Test
    public void pushBunsButtonTest() throws InterruptedException {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushSaucesButton();
        Thread.sleep(500);
        homePage.waitAndPushBunsButton();
        Thread.sleep(500);

        homePage.bunsButtonDoesNotExist();
        homePage.currentBunsExist();
    }

    @Test
    public void pushSaucesButtonTest() throws InterruptedException {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushSaucesButton();
        Thread.sleep(500);

        homePage.saucesButtonDoesNotExist();
        homePage.currentSaucesExist();
    }

    @Test
    public void pushFillingsButtonTest() throws InterruptedException {
        HomePage homePage = page(HomePage.class);
        homePage.waitAndPushFillingsButton();
        Thread.sleep(500);

        homePage.fillingsButtonDoesNotExist();
        homePage.currentFillingsExist();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
