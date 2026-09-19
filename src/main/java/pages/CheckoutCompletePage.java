package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CheckoutCompletePage extends BasePage {

    private final Locator completeHeader;

    public CheckoutCompletePage(Page page) {
        super(page);
        completeHeader = page.locator("[data-test='complete-header']");
    }

    public boolean isCompleteHeaderVisible() {
        completeHeader.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return completeHeader.isVisible();
    }
}
