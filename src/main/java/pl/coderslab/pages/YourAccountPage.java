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

public class YourAccountPage {

    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@id='addresses-link']/span/i")
    private WebElement addressesIcon;

    @FindBy(xpath = "//*[@id='search_widget']/form/input[2]")
    private WebElement searchOurCatalogBar;

    @FindBy(xpath = "//span[@class='product' and text()='Hummingbird printed sweater']")
    private WebElement chooseSweater;

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddressesIcon() {

        addressesIcon.click();
    }

    public void clickSearchOurCatalogBar() {

        searchOurCatalogBar.click();
    }

    public void clickChooseSweater() {
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='product' and text()='Hummingbird printed sweater']")));
        chooseSweater.click();
    }

    public void typeProductInTheSearchBar(String product) {
        searchOurCatalogBar.clear();
        searchOurCatalogBar.click();
        searchOurCatalogBar.sendKeys(product);
    }


}


