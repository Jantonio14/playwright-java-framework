package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage extends BasePage{

    private final Locator checkoutButton;

    public CartPage(Page page) {
        super(page);
        checkoutButton = page.locator("[data-test='checkout']");
    }

    public void clickCheckout() {
        checkoutButton.click();
    }
}
