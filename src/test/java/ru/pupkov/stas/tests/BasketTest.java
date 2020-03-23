package ru.pupkov.stas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import ru.pupkov.stas.base.SettingsForBrowser;
import ru.pupkov.stas.doc.Basket;

public class BasketTest extends SettingsForBrowser implements Basket {

    @BeforeEach
    public void testPreparation() {
        AppsListPage appsListPage = new AppsListPage();
        waitingAppearanceVisibility(appsListPage.getAppTitle());
        appsListPage.clickAppByTitle("Интеграция 1С 8");
    }

    @Test
    public void appAppearanceInBasket() {
        AppPage appPage = new AppPage();
        waitingAppearanceVisibility(appPage.getBasketButton());
        clickBy(appPage.getBasketButton());

        BasketForm basketForm = new BasketForm();
        waitingAppearanceVisibility(basketForm.getItemFromList());
        Assert.assertTrue(basketForm.getItemFromList().getText().contains("Интеграция 1С 8"));

        basketForm.clickCloseButton();
        Assert.assertEquals("1", new HeaderBar().getCountItems());
        Assert.assertEquals("В КОРЗИНЕ", driver.findElement(appPage.getBasketButton()).getText());
    }
}