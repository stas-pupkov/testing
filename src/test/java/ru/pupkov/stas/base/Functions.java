package ru.pupkov.stas.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.URL;


public class Functions extends Utils {

    /**
     * Универсальный метод
     * Открытие браузера в контейнере docker'a
     */
    public WebDriver openDefiniteBrowser() {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName(BROWSER_NAME);
        capability.setVersion(BROWSER_VERSION);
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        capability.setCapability("enableVNC", true);
        capability.setCapability("env", new String[]{"LANG=ru_RU.UTF-8", "LANGUAGE=ru:en", "LC_ALL=ru_RU.UTF-8"});

        //Запускаем браузер с настройками черер Docker
        try {
            return driver = new RemoteWebDriver(new URL("http://" + SELENOID_HOST + ":" + SELENOID_PORT + "/wd/hub"), capability);
        } catch (Exception e) {
            //Если нет Docker'a, запустится локально
            return new ChromeDriver(capability);
        }
    }

    /**
     * Ожидание появления заданного элемента на экране
     * @param bySomething - параметр элемента
     */
    public void waitingAppearanceVisibility(By bySomething) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySomething));
    }

    /**
     * Нажать по заданному элементу
     */
    public void clickBy(By bySomething) {
        Assert.assertTrue(driver.findElement(bySomething).isDisplayed());
        driver.findElement(bySomething).click();
    }
    public void clickBy(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());
        webElement.click();
    }

}