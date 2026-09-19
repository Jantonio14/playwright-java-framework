package ui;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;

    @BeforeEach
    void setup() {
        playwright = Playwright.create();

        // Explicitly force headless — don't rely on Playwright's default.
        // CI runners have no display server, so headed mode crashes there.
        // System.getenv("CI") is auto-set to "true" by GitHub Actions on every run,
        // so this lets you still watch tests run headed locally if you want.
        boolean isCI = System.getenv("CI") != null;
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(isCI)
        );

        page = browser.newPage();
    }

    @AfterEach
    void tearDown() {
        browser.close();
        playwright.close();
    }
}
