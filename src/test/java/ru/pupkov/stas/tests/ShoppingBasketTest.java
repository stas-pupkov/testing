package ru.pupkov.stas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.pupkov.stas.base.SettingsForBrowser;
import ru.pupkov.stas.doc.ShoppingBasket;

public class ShoppingBasketTest extends SettingsForBrowser implements ShoppingBasket {

    @BeforeEach
    public void testPreparation() {
        ShoppingPage page = new ShoppingPage();
        waitingAppearanceVisibility(page.getSearchField());
        page.setTitleDesiredItemInSearch(desiredItem);
        page.clickSearchButton();
        clickBy(driver.findElements(By.className("sm-image-holder")).get(0));
    }

    @Test
    public void appearancePopupWindowWhenAddItem() {
        ShoppingPage page = new ShoppingPage();
        clickBy(page.getAddToBasket());
        waitingAppearanceVisibility(page.getPopupWindow());
    }
}