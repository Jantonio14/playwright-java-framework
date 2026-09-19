package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class InventoryPage extends BasePage {

    private final Locator productsTitle;

    public InventoryPage(Page page) {
        super(page);
        productsTitle = page.locator(".title");
    }

    public boolean isProductsTitleVisible() {
        return productsTitle.isVisible();
    }
}
