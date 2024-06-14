package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourAccountPage {

    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='addresses-link']/span/i")
    private WebElement addressesIcon;

    @FindBy(xpath = "//*[@id='main']/header/h1")
    private WebElement yourAccountHeading;

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddressesIcon() {

        addressesIcon.click();
    }

    public String yourAccountTextIsDisplayed() {
        return yourAccountHeading.getText();
    }



}


