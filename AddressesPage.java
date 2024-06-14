package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AddressesPage {

    private final WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(), 'Create new address')]")
    private WebElement createNewAddressField;

    @FindBy(xpath = "//li[contains(text(), 'Address successfully added!')]")
    private WebElement successMessageAddingNewAddress;

    @FindBy(xpath = "//*[@id='main']/header/h1")
    private WebElement yourAddressesHeading;


    public AddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickCreateNewAddress() {
        createNewAddressField.click();
    }

    public String yourAddressesTextIsDisplayed() {
        return yourAddressesHeading.getText();
    }

    public String successMessageAddingNewAddressIsDisplayed() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(text(), 'Address successfully added!')]")));
        return successMessageAddingNewAddress.getText();
    }


}


