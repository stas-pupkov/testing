package ru.pupkov.stas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Pages {

    public static WebDriver driver;
    public static Random rnd = new Random(System.currentTimeMillis());

    /**
     * Главная страница сайта www.sportmaster.ru
     */
    public class SportmasterMainPage {
        private By nameField = By.id("inputEmail");
        private By passwordField = By.id("inputPassword");
        private By loginButton = By.id("log-in");
        private By danger = By.cssSelector("[data-bind*='InvalidLoginPassword']");
        private By listLanguages = By.id("changeLocale");

        /**
         * Ввести имя пользователя
         */
        public void setName(String name) {
            driver.findElement(nameField).sendKeys(name);
        }

        /**
         * Ввести пароль
         */
        public void setPassword(String password) {
            driver.findElement(passwordField).sendKeys(password);
        }

        /**
         * Нажать на кнопку "Войти"
         */
        public void clickLogin() {
            driver.findElement(loginButton).click();
        }

        /**
         * Получить указатель на кнопку "Войти"
         */
        public By getLoginButton() {
            return loginButton;
        }

        /**
         * Получить поле с сообщением о неверном логине/пароле
         */
        public WebElement getDangerField() {
            return driver.findElement(danger);
        }

        /**
         * Нажать на кнопку выбора языка
         */
        public void clickListLanguages() {
            driver.findElement(listLanguages).click();
        }
    }
}