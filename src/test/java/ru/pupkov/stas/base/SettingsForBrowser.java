package ru.pupkov.stas.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.TimeUnit;

public class SettingsForBrowser extends Functions {

    @BeforeEach
    public void openBrowser() {
        driver = openDefiniteBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://" + URL_HOST);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
