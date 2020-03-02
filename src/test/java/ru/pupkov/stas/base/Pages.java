package ru.pupkov.stas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Pages {

    public static WebDriver driver;

    /**
     * Шапка страницы сайта
     */
    public class HeaderBar {
        private By loginButton = By.cssSelector("[data-selenium = 'link_login']");
        private By welcome = By.className("headerBar__welcome");

        /**
         * Получить указатель на кнопку "Войти"
         */
        public By getLoginButton() {
            return loginButton;
        }

        /**
         * Получить указатель на поле приветствия пользователя
         */
        public By getWelcome() {
            return welcome;
        }
    }

    /**
     * Страница авторизации
     */
    public class AuthorizationPage {
        private By authorizationForm = By.id("loginForm");
        private By emailField = By.cssSelector("[data-selenium = 'auth-field-email']");
        private By passwordField = By.cssSelector("[data-selenium = 'auth-field-password']");
        private By enterButton = By.id("submitButton");

        private By loginOrPasswordError = By.cssSelector("[data-selenium = 'auth-error-description']");

        /**
         * Получить указатель на форму авторизации
         */
        public By getAuthorizationForm() {
            return authorizationForm;
        }

        /**
         * Вкладка авторизации по e-mail
         * Ввести адрес электронной почты в поле "E-mail"
         */
        public void setEmail(String email) {
            Assert.assertTrue(driver.findElement(emailField).isDisplayed());
            driver.findElement(emailField).clear();
            driver.findElement(emailField).sendKeys(email);
        }

        /**
         * Ввести пароль в поле "Пароль"
         */
        public void setPassword(String password) {
            Assert.assertTrue(driver.findElement(passwordField).isDisplayed());
            driver.findElement(passwordField).clear();
            driver.findElement(passwordField).sendKeys(password);
        }

        /**
         * Нажать кнопку "Войти"
         */
        public void clickEnterButton() {
            Assert.assertTrue(driver.findElement(enterButton).isDisplayed());
            driver.findElement(enterButton).click();
        }

        /**
         * Проверить, что появилось сообщение об ошибке логина или пароля
         */
        public void checkErrorLoginOrPassword() {
            Assert.assertTrue(driver.findElement(loginOrPasswordError).isDisplayed());
            driver.findElement(loginOrPasswordError).getText().matches("Неверный логин или пароль");
        }
    }

    /**
     * Форма для совершения покупок
     */
    public class ShoppingPage {
        private By searchField = By.cssSelector("[data-selenium = 'product_search_input']");
        private By submitSearchButton = By.cssSelector("[data-selenium = 'product_search_button']");
        private By addToBasketButton = By.cssSelector("[data-selenium = 'add_to_basket']");
        private By popupWindow = By.id("basketMessage");

        /**
         * Получить указатель на поле поиска товара
         */
        public By getSearchField() {
            return searchField;
        }

        /**
         * Ввести название искомого товара в поле поиска
         */
        public void setTitleDesiredItemInSearch(String title) {
            Assert.assertTrue(driver.findElement(searchField).isDisplayed());
            driver.findElement(searchField).clear();
            driver.findElement(searchField).sendKeys(title);
        }

        /**
         * Нажать кнопку поиска товара
         */
        public void clickSearchButton() {
            Assert.assertTrue(driver.findElement(submitSearchButton).isDisplayed());
            driver.findElement(submitSearchButton).click();
        }

        /**
         * Получить указатель на кнопку добавления товара в корзину
         */
        public By getAddToBasket() {
            return addToBasketButton;
        }

        /**
         * Получить указатель на всплывающее сообщение о добавлении товара в корзину
         */
        public By getPopupWindow() {
            return popupWindow;
        }


    }
}