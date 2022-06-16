package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends GeneralMethods{

    //Кнопка Войти в аккаунт
    public SelenideElement loginButton = $x("//button[text()='Войти в аккаунт']");

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public LoginPage waitAndPushLoginButton(){
            waitAndVisibleButton(loginButton);
            pushButton(loginButton);
            return page(LoginPage.class);
        }

    //Кнопка Личный Кабинет
    public SelenideElement accountButton = $(byAttribute("href", "/account"));

        //Метод ожидания видимости кнопки и нажатия на неё для перехода в Личный кабинет
        public AccountProfilePage waitAndPushAccountButton(){
            waitAndVisibleButton(accountButton);
            pushButton(accountButton);
            return page(AccountProfilePage.class);
        }

    //Кнопка Булки
    public SelenideElement bunsButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Булки']");
        //Изменения класса в div после нажатия на кнопку Булки
        public SelenideElement currentBuns = $x("//div[contains(@class,'_current_')]/span[text()='Булки']");

        //Метод ожидания видимости кнопки Булки и нажатия на неё
        public void waitAndPushBunsButton(){
            waitAndVisibleButton(bunsButton);
            pushButton(bunsButton);
        }

        //Метод проверки, что кнопка Булки НЕ существует
        public void bunsButtonDoesNotExist() {
            bunsButton.shouldNot(exist);
        }

        //Метод проверки, что кнопка currentBuns существует
        public void currentBunsExist() {
            currentBuns.should(exist);
        }


    //Кнопка Соусы
    public SelenideElement saucesButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Соусы']");
        //Изменения класса в div после нажатия на кнопку Соусы
        public SelenideElement currentSauces = $x("//div[contains(@class,'_current_')]/span[text()='Соусы']");

        //Метод ожидания видимости кнопки Соусы и нажатия на неё
        public void waitAndPushSaucesButton(){
            waitAndVisibleButton(saucesButton);
            pushButton(saucesButton);
        }

        //Метод проверки, что кнопка Соусы НЕ существует
        public void saucesButtonDoesNotExist() {
            saucesButton.shouldNot(exist);
        }

        //Метод проверки, что кнопка currentSauces существует
        public void currentSaucesExist() {
            currentSauces.should(exist);
        }

    //Кнопка Начинки
    public SelenideElement fillingsButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Начинки']");
        //Изменения класса в div после нажатия на кнопку Начинки
        public SelenideElement currentFillings = $x("//div[contains(@class,'_current_')]/span[text()='Начинки']");

        //Метод ожидания видимости кнопки Начинки и нажатия на неё
        public void waitAndPushFillingsButton(){
            waitAndVisibleButton(fillingsButton);
            pushButton(fillingsButton);
        }

        //Метод проверки, что кнопка Начинки НЕ существует
        public void fillingsButtonDoesNotExist() {
            fillingsButton.shouldNot(exist);
        }

        //Метод проверки, что кнопка currentFillings существует
        public void currentFillingsExist() {
            currentFillings.should(exist);
        }
}
