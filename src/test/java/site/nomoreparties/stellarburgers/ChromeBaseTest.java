package site.nomoreparties.stellarburgers;

import api.User;
import api.UserClient;
import org.junit.After;
import org.junit.Before;


public class ChromeBaseTest extends UserGeneration{

    protected String homePageURL = "https://stellarburgers.nomoreparties.site/";
    protected String loginPageURL = "https://stellarburgers.nomoreparties.site/login";
    protected String registerPageURL = "https://stellarburgers.nomoreparties.site/register";
    protected String profilePageURL = "https://stellarburgers.nomoreparties.site/account/profile";

    protected UserClient client = new UserClient();
    protected UserGeneration gen = new UserGeneration();
    protected User user = new User(gen.randomEmail(), gen.randomPassword(), gen.randomName());

    @Before
    public void setUp(){
        client.registerUser(user);
    }

    @After
    public void tearDown() throws InterruptedException {
        String body = client.loginUser(user).and().extract().body().path("accessToken");
        Thread.sleep(800);
        if (body != null) {
            client.deleteUser(user);
        }
    }
}
