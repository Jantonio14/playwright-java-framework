package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutAddressPage extends BasePage {

    private final Locator firstNameInput;
    private final Locator lastNameInput;
    private final Locator postalCodeInput;
    private final Locator continueButton;

    public CheckoutAddressPage(Page page) {
        super(page);
        firstNameInput = page.locator("[data-test='firstName']");
        lastNameInput = page.locator("[data-test='lastName']");
        postalCodeInput = page.locator("[data-test='postalCode']");
        continueButton = page.locator("[data-test='continue']");
    }

    public void fillFirstName(String firstName) {
        firstNameInput.fill(firstName);
    }

    public void fillLastName(String lastName) {
        lastNameInput.fill(lastName);
    }

    public void fillPostalCode(String postalCode) {
        postalCodeInput.fill(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
