package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class InventoryPage extends BasePage {

    private final Locator productsTitle;
    private final Locator addOnesieToCartButton;
    private final Locator cartLink;

    public InventoryPage(Page page) {
        super(page);
        productsTitle = page.locator("[data-test='title']");
        addOnesieToCartButton = page.locator("[data-test='add-to-cart-sauce-labs-onesie']");
        cartLink = page.locator("[data-test='shopping-cart-link']");
    }

    public boolean isProductsTitleVisible() {
        productsTitle.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return productsTitle.isVisible();
    }

    public void addOnesieToCart() {
        addOnesieToCartButton.click();
    }

    public void goToCart() {
        cartLink.click();
    }
}
