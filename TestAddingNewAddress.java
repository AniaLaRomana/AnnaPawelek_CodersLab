package TestAddingNewAddress;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.pages.LogInToYourAccountPage;
import pl.coderslab.pages.YourAccountPage;
import pl.coderslab.pages.AddressesPage;
import pl.coderslab.pages.NewAddressPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddingNewAddress {

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
    public void shouldAddNewAddress() {
        LogInToYourAccountPage logInToYourAccountPage = new LogInToYourAccountPage(driver);
        logInToYourAccountPage.typeEmailToLogIn("ladybug@meadow.com");
        logInToYourAccountPage.typePasswordToLogIn("LadyBugOnTheMeadow!@#");
        logInToYourAccountPage.clickSignInButton();

        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.clickAddressesIcon();

        AddressesPage addressesPage = new AddressesPage(driver);
        addressesPage.clickCreateNewAddress();

        NewAddressPage newAddressPage = new NewAddressPage(driver);
        newAddressPage.typeFirstName("RandomName");
        newAddressPage.typeLastName("RandomSurname");
        newAddressPage.typeAddress("RandomAddress");
        newAddressPage.typeCity("RandomCity");
        newAddressPage.typePostalCode(222333);
        newAddressPage.clickSaveButton();
        assertEquals("Address successfully added!", addressesPage.successMessageAddingNewAddressIsDisplayed());

    }
}
