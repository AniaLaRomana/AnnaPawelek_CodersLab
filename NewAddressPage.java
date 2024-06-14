package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAddressPage {

    private final WebDriverWait wait;

    @FindBy(id = "field-firstname")
    private WebElement firstNameField;

    @FindBy(id = "field-lastname")
    private WebElement lastNameField;

    @FindBy(id = "field-address1")
    private WebElement addressField;

    @FindBy(id = "field-city")
    private WebElement cityField;

    @FindBy(id = "field-postcode")
    private WebElement postalCodeField;

    @FindBy(xpath = "//button[@class='btn btn-primary form-control-submit float-xs-right' and @type='submit']")
    private WebElement saveButton;



    public NewAddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void typeFirstName(String firstname) {
        firstNameField.clear();
        firstNameField.sendKeys(firstname);
    }

    public void typeLastName(String lastname) {
        lastNameField.clear();
        lastNameField.sendKeys(lastname);
    }

    public void typeAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }

    public void typeCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }

    public String typePostalCode(int postalcode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(Integer.toString(postalcode));
        return Integer.toString(postalcode);
    }


    public void clickSaveButton() {
        saveButton.click();
    }

}

