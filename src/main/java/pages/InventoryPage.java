package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InventoryPage extends BasePage {

    private final Locator productsTitle;

    public InventoryPage(Page page) {
        super(page);
        productsTitle = page.locator("[data-test='title']");
    }

    public boolean isProductsTitleVisible() {
        productsTitle.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return productsTitle.isVisible();
    }
}
