package site.nomoreparties.stellarburgers.ChromeBrowser;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class TransitToSectionTest {

    @Before
    public void setUp() {
        Selenide.open("https://stellarburgers.nomoreparties.site/", HomePage.class);
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
}
