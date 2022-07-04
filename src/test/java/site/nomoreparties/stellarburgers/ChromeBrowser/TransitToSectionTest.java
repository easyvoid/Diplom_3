package site.nomoreparties.stellarburgers.ChromeBrowser;

import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.ChromeBaseTest;
import site.nomoreparties.stellarburgers.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class TransitToSectionTest extends ChromeBaseTest {

    @Before
    public void setUp() {
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
}
