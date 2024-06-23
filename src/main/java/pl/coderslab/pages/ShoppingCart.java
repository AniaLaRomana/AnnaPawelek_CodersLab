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

public class ShoppingCart {

    private final WebDriverWait wait;

    @FindBy(xpath = "//a[text()='Proceed to checkout']")
    private WebElement proceedToCheckOutButton2;


    public ShoppingCart(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickProceedToCheckoutButton2() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Proceed to checkout']")));
        proceedToCheckOutButton2.click();
    }

}
