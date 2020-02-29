package ru.pupkov.stas.tests;

import org.junit.jupiter.api.Test;
import ru.pupkov.stas.base.SettingsForBrowser;
import ru.pupkov.stas.doc.Add;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AddTest extends SettingsForBrowser implements Add {

    @Test
    public void a1() {
        assertTrue(true);
    }
}