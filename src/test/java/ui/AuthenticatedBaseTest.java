package ui;

import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;
import utils.ConfigReader;

public class AuthenticatedBaseTest extends BaseTest {

    @BeforeEach
    void loginBeforeEach() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.open();

        loginPage.enterUsername(ConfigReader.get("sauce.username"));
        loginPage.enterPassword(ConfigReader.get("sauce.password"));
        loginPage.clickLogin();
    }
}
