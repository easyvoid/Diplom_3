package site.nomoreparties.stellarburgers.YandexBrowser;

import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import site.nomoreparties.stellarburgers.HomePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static org.junit.Assert.assertEquals;

public class TransitToSectionTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\yandexdriver.exe");
        driver = new ChromeDriver();
        setWebDriver(driver);

        open("https://stellarburgers.nomoreparties.site/", HomePage.class);
    }

    @Test
    public void pushBunsButtonTest() throws InterruptedException {
        HomePage.saucesButton.click();
        Thread.sleep(500);
        HomePage.bunsButton.click();
        Thread.sleep(500);

        SelenideElement expectedLocator = $x("//div[contains(@class,'_current_')]/span[text()='Булки']");
        SelenideElement actualLocator = HomePage.currentBuns;
        assertEquals(expectedLocator, actualLocator);
    }

    @Test
    public void pushSaucesButtonTest() throws InterruptedException {
        HomePage.saucesButton.click();
        Thread.sleep(500);

        SelenideElement expectedLocator = $x("//div[contains(@class,'_current_')]/span[text()='Соусы']");
        SelenideElement actualLocator = HomePage.currentSauces;
        assertEquals(expectedLocator, actualLocator);
    }

    @Test
    public void pushFillingsButtonTest() throws InterruptedException {
        HomePage.fillingsButton.click();
        Thread.sleep(500);

        SelenideElement expectedLocator = $x("//div[contains(@class,'_current_')]/span[text()='Начинки']");
        SelenideElement actualLocator = HomePage.currentFillings;
        assertEquals(expectedLocator, actualLocator);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
