package ru.pupkov.stas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Iterator;
import java.util.List;

public class Pages {

    public static WebDriver driver;

    /**
     * Шапка страницы сайта
     */
    public class HeaderBar {
        private By basketArea = By.cssSelector("[class*='basket search-active-tablet-hide']");
        private By count = By.className("amount");

        /** Получить отображаемое количество товаров в корзине */
        public String getCountItems() {
            return driver.findElement(basketArea).findElement(count).getText();
        }
    }

    /**
     * Страница выбора приложений
     */
    public class AppsListPage {
        private By appTitle = By.className("app-title");

        /** Получить указатель на плитку приложения */
        public By getAppTitle() {
            return appTitle;
        }

        /** Выбрать приложение по его имени */
        public void clickAppByTitle(String title) {
            List<WebElement> apps = driver.findElements(appTitle);
            Iterator<WebElement> iterator = apps.iterator();
            while (iterator.hasNext()) {
                WebElement application = iterator.next();
                if (application.getText().matches(title)) {
                        application.click();
                        break;
                }
            }
        }
    }

    /**
     * Страница выбранного приложения
     */
    public class AppPage {
        private By basketButton = By.className("plan-item-controls__basket-button");

        /** Получить указатель на кнопку добавления приложения в корзину */
        public By getBasketButton() {
            return basketButton;
        }
    }

    /**
     * Форма корзины
     */
    public class BasketForm {
        private By lineWithItem = By.className("basket__list-item");
        private By close = By.className("evo-sidebar__close");

        /** Получить первую строчку товаров в корзине */
        public WebElement getItemFromList() {
            return driver.findElements(lineWithItem).get(0);
        }

        /** Нажать на крестик закрытия формы корзины */
        public void clickCloseButton() {
            driver.findElement(close).click();
        }
    }
}