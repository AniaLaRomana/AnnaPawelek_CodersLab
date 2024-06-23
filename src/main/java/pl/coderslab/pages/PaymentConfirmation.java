package pl.coderslab.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class PaymentConfirmation {

    private final WebDriverWait wait;
    private final WebDriver driver;

    @FindBy(xpath = "//input[@id='payment-option-1']")
    private WebElement payByCheckButton;

    @FindBy(xpath = "//input[@id='conditions_to_approve[terms-and-conditions]' and @value='1']")
    private WebElement termsOfServiceButton;

    @FindBy(xpath = "//button[@class='btn btn-primary center-block']")
    private WebElement placeOrderButton;

    public PaymentConfirmation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickPayByCheckButton() {
        payByCheckButton.click();
    }

    public void clickTermsOfService() {
        termsOfServiceButton.click();
    }

    public void clickPlaceOrderButton() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary center-block']")));
        placeOrderButton.click();
    }

    public void takeScreenshot() {
        System.out.println("Taking screenshot...");
        TakesScreenshot scrsht = (TakesScreenshot) driver;
        File screenshot = scrsht.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots/page.png");

        try {
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
