package site.nomoreparties.stellarburgers.ChromeBrowser;

import com.codeborne.selenide.Selenide;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.BaseTest;
import site.nomoreparties.stellarburgers.HomePage;

import static com.codeborne.selenide.Selenide.*;

public class TransitToSectionTest extends BaseTest {

    @Before
    public void setUp() {
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
}
