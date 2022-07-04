package site.nomoreparties.stellarburgers;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.*;

public class HomePage extends GeneralMethods{

    //Кнопка Войти в аккаунт
    private SelenideElement loginButton = $x("//button[text()='Войти в аккаунт']");

        //Метод проверки отсутствия кнопки логина
        public void loginButtonShouldDisappear(){
            buttonShouldDisappear(loginButton);
        }

        //Метод ожидания видимости кнопки и нажатия на неё для Логина
        public LoginPage waitAndPushLoginButton(){
            waitAndVisibleButton(loginButton);
            pushButton(loginButton);
            return page(LoginPage.class);
        }

    //Кнопка Личный Кабинет
    private SelenideElement accountButton = $(byAttribute("href", "/account"));

        //Метод ожидания видимости кнопки и нажатия на неё для перехода в Личный кабинет
        public AccountProfilePage waitAndPushAccountButton(){
            waitAndVisibleButton(accountButton);
            pushButton(accountButton);
            return page(AccountProfilePage.class);
        }

    //Кнопка Булки
    private SelenideElement bunsButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Булки']");
        //Изменения класса в div после нажатия на кнопку Булки
        private SelenideElement currentBuns = $x("//div[contains(@class,'_current_')]/span[text()='Булки']");

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
        public void currentBunsExistAndVisible() {
            waitAndVisibleButton(currentBuns);
        }


    //Кнопка Соусы
    private SelenideElement saucesButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Соусы']");
        //Изменения класса в div после нажатия на кнопку Соусы
        private SelenideElement currentSauces = $x("//div[contains(@class,'_current_')]/span[text()='Соусы']");

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
        public void currentSaucesExistAndVisible() {
            waitAndVisibleButton(currentSauces);
        }

    //Кнопка Начинки
    private SelenideElement fillingsButton = $x("//div[contains(@class,'tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect')]/span[text()='Начинки']");
        //Изменения класса в div после нажатия на кнопку Начинки
        private SelenideElement currentFillings = $x("//div[contains(@class,'_current_')]/span[text()='Начинки']");

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
        public void currentFillingsExistAndVisible() {
            waitAndVisibleButton(currentFillings);
        }

    @Step("Возвращает Email из Личного Кабинета")
    public String checkAccountProfile() {
        HomePage homePage = page(HomePage.class);
        AccountProfilePage accountProfilePage = homePage.waitAndPushAccountButton();
        return accountProfilePage.checkLoginFieldValue();
    }
}
