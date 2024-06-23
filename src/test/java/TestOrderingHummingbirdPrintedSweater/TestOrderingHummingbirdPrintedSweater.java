package TestOrderingHummingbirdPrintedSweater;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.LogInToYourAccountPage;
import pl.coderslab.pages.YourAccountPage;
import pl.coderslab.pages.HummingbirdPrintedSweater;
import pl.coderslab.pages.ShoppingCart;
import pl.coderslab.pages.OrderAddressConfirmation;
import pl.coderslab.pages.ShippingMethodConfirmation;
import pl.coderslab.pages.PaymentConfirmation;


public class TestOrderingHummingbirdPrintedSweater {

    private WebDriver driver;

    @BeforeEach
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldCompleteOrder() {
        LogInToYourAccountPage logInToYourAccountPage = new LogInToYourAccountPage(driver);
        logInToYourAccountPage.typeEmailToLogIn("ladybug@meadow.com");
        logInToYourAccountPage.typePasswordToLogIn("LadyBugOnTheMeadow!@#");
        logInToYourAccountPage.clickSignInButton();

        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickSearchOurCatalogBar();
        yourAccountPage.typeProductInTheSearchBar("Hummingbird Printed Sweater");
        yourAccountPage.clickChooseSweater();


        HummingbirdPrintedSweater hummingbirdPrintedSweater = new HummingbirdPrintedSweater(driver);
        hummingbirdPrintedSweater.selectProductSize();
        hummingbirdPrintedSweater.selectProductQuantity();
        hummingbirdPrintedSweater.clickAddToCart();
        hummingbirdPrintedSweater.clickProceedToCheckoutButton();

        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.clickProceedToCheckoutButton2();

        OrderAddressConfirmation orderAddressConfirmation = new OrderAddressConfirmation(driver);
        orderAddressConfirmation.clickOrderAddressConfirmation();

        ShippingMethodConfirmation shippingMethodConfirmation = new ShippingMethodConfirmation(driver);
        shippingMethodConfirmation.clickOrderAddressConfirmation();

        PaymentConfirmation paymentConfirmation = new PaymentConfirmation(driver);
        paymentConfirmation.clickPayByCheckButton();
        paymentConfirmation.clickTermsOfService();
        paymentConfirmation.clickPlaceOrderButton();
        paymentConfirmation.takeScreenshot();

    }
}
