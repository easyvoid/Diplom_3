package site.nomoreparties.stellarburgers;

import api.User;
import api.UserClient;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.WebDriverRunner.setWebDriver;

public class YandexBaseTest {
    protected String homePageURL = "https://stellarburgers.nomoreparties.site/";
    protected String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
    protected String registerPageURL = "https://stellarburgers.nomoreparties.site/register";
    protected String profilePageURL = "https://stellarburgers.nomoreparties.site/account/profile";

    protected UserClient client = new UserClient();
    protected UserGeneration gen = new UserGeneration();
    protected User user = new User(gen.randomEmail(), gen.randomPassword(), gen.randomName());
    protected ChromeDriver driver;


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
        Thread.sleep(800);
        client.deleteUser(user);
    }
}
