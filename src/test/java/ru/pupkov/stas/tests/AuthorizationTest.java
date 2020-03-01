package ru.pupkov.stas.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pupkov.stas.base.SettingsForBrowser;
import ru.pupkov.stas.doc.Authorization;

public class AuthorizationTest extends SettingsForBrowser implements Authorization {

    @BeforeEach
    public void testPreparation() {
        HeaderBar headerBar = new HeaderBar();
        waitingAppearanceVisibility(headerBar.getLoginButton());
        clickBy(headerBar.getLoginButton());
    }

    @Test
    public void enterByCorrectEmail() {
        AuthorizationPage authPage = new AuthorizationPage();
        waitingAppearanceVisibility(authPage.getAuthorizationForm());
        authPage.setEmail(email);
        authPage.setPassword(password);
        authPage.clickEnterButton();

        waitingAppearanceVisibility(new HeaderBar().getWelcome());
    }

    @Test
    public void enterWithIncorrectPassword() {
        AuthorizationPage authPage = new AuthorizationPage();
        waitingAppearanceVisibility(authPage.getAuthorizationForm());
        authPage.setEmail(email);
        authPage.setPassword(incorrectPassword);
        authPage.clickEnterButton();

        authPage.checkErrorLoginOrPassword();
    }
}