package ui;


import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestDataGenerator;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTests extends AuthenticatedBaseTest {

    @Test
    void checkoutItem() {
        InventoryPage inventoryPage = new InventoryPage(page);
        inventoryPage.addOnesieToCart();
        inventoryPage.goToCart();

        CartPage cartPage = new CartPage(page);
        cartPage.clickCheckout();

        CheckoutAddressPage checkoutAddressPage = new CheckoutAddressPage(page);
        checkoutAddressPage.fillFirstName(TestDataGenerator.randomFirstName());
        checkoutAddressPage.fillLastName(TestDataGenerator.randomLastName());
        checkoutAddressPage.fillPostalCode(TestDataGenerator.randomZipCode());
        checkoutAddressPage.clickContinue();

        CheckoutFinalizePage checkoutFinalizePage = new CheckoutFinalizePage(page);
        checkoutFinalizePage.clickFinish();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(page);
        assertTrue(checkoutCompletePage.isCompleteHeaderVisible());
    }
}
