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

public class OrderAddressConfirmation {

    private final WebDriverWait wait;

    @FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary continue float-xs-right' and @name='confirm-addresses' and @value='1']")
    private WebElement continueButton;

    public OrderAddressConfirmation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickOrderAddressConfirmation() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit' and @class='btn btn-primary continue float-xs-right' and @name='confirm-addresses' and @value='1']")));
        continueButton.click();
    }


}
