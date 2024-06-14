package pl.coderslab.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInToYourAccountPage {

    private final WebDriverWait wait;

    @FindBy(id = "field-email")
    private WebElement insertEmailField;

    @FindBy(id = "field-password")
    private WebElement insertPasswordField;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    public LogInToYourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void typeEmailToLogIn(String email) {
        insertEmailField.clear();
        insertEmailField.sendKeys(email);
    }

    public void typePasswordToLogIn(String password) {
        insertPasswordField.clear();
        insertPasswordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }
}
