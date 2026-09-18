package ui;

import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();

        loginPage.enterUsername(ConfigReader.get("username"));
        loginPage.enterPassword(ConfigReader.get("password"));
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(page);
        assertTrue(inventoryPage.isProductsTitleVisible());
    }

    @Test
    void invalidShowLoginError() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();

        loginPage.enterUsername("Wrong_user");
        loginPage.enterPassword("wrong_pw");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("Username and password do not match"));
    }
}
