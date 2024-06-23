package pl.coderslab.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HummingbirdPrintedSweater {

    private final WebDriverWait wait;

    @FindBy(xpath = "//select[@id='group_1']")
    private WebElement selectSizeDropdown;

    @FindBy(xpath = "//button[@data-button-action='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@href, 'controller=cart') and contains(@class, 'btn btn-primary')]")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    private WebElement increaseProductQuantity;



    public HummingbirdPrintedSweater(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void selectProductSize() {
        Select select = new Select(selectSizeDropdown);
        select.selectByValue("2");
    }

    public void selectProductQuantity() {
        increaseProductQuantity.click();
        String currentValue = increaseProductQuantity.getAttribute("value");
        for (int i = 0; i < currentValue.length(); i++) {
            increaseProductQuantity.sendKeys(Keys.BACK_SPACE);
        }
        increaseProductQuantity.sendKeys("5");
    }

    public void clickAddToCart() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@data-button-action='add-to-cart']")));
        addToCartButton.click();
    }

    public void clickProceedToCheckoutButton() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href, 'controller=cart') and contains(@class, 'btn btn-primary')]")));
        proceedToCheckoutButton.click();
    }

}
