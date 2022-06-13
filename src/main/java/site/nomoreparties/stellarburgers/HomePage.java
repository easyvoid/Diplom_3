package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    //Кнопка Войти в аккаунт
    public static SelenideElement loginButton = $x("//button[text()='Войти в аккаунт']");

        //Метод скрола и ожидания появления элемента (кнопки)
        public void waitAndVisibleButton(SelenideElement element){
            element.scrollTo();
            element.shouldBe(visible, enabled);
        }

        //Метод нажатия на кнопку
        public void pushButton(SelenideElement element){
        element.click();
        }

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public LoginPage waitAndPushLoginButton(){
            waitAndVisibleButton(loginButton);
            pushButton(loginButton);
            return page(LoginPage.class);
        }

    //Кнопка Личный Кабинет
    public static SelenideElement accountButton = $(byAttribute("href", "/account"));

        //Метод ожидания видимости кнопки и нажатия на неё для перехода в Личный кабинет
        public AccountProfilePage waitAndPushAccountButton(){
            waitAndVisibleButton(accountButton);
            pushButton(accountButton);
            return page(AccountProfilePage.class);
        }

    //Кнопка Булки
    public static SelenideElement bunsButton = $x("//span[text()='Булки']");
        //Изменения класса в div после нажатия на кнопку Булки
        public static SelenideElement currentBuns = $x("//div[contains(@class,'_current_')]/span[text()='Булки']");

    //Кнопка Соусы
    public static SelenideElement saucesButton = $x("//span[text()='Соусы']");
        //Изменения класса в div после нажатия на кнопку Соусы
        public static SelenideElement currentSauces = $x("//div[contains(@class,'_current_')]/span[text()='Соусы']");

    //Кнопка Начинки
    public static SelenideElement fillingsButton = $x("//span[text()='Начинки']");
        //Изменения класса в div после нажатия на кнопку Начинки
        public static SelenideElement currentFillings = $x("//div[contains(@class,'_current_')]/span[text()='Начинки']");
}
