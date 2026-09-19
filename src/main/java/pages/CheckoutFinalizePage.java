package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutFinalizePage extends BasePage {

    private final Locator finishButton;

    public CheckoutFinalizePage(Page page) {
        super(page);
        finishButton = page.locator("[data-test='finish']");
    }

    public void clickFinish() {
        finishButton.click();
    }
}
