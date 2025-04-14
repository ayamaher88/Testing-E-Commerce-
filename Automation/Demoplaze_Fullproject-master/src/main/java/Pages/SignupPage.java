package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By signupLink = By.xpath("//a [text()='Sign up']");
    private By signupUsernameField = By.id("sign-username");
    private By signupPasswordField = By.id("sign-password");
    private By signupButton = By.xpath("//button[contains(text(),'Sign up')]");

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public void clicksignuplink() {
        WebElement signupLinkElement = wait.until((ExpectedConditions.elementToBeClickable(signupLink)));
        signupLinkElement.click();
    }

    public void entersignupUsername(String username) {
        WebElement signupusernamefield = wait.until(ExpectedConditions.elementToBeClickable(signupUsernameField));
        signupusernamefield.sendKeys(username);
    }

    public void entersignuppassword(String password) {
        WebElement signuppasswordfield = wait.until(ExpectedConditions.elementToBeClickable(signupPasswordField));
        signuppasswordfield.sendKeys(password);
    }

    public void clicksignupButton() {
        WebElement signupbutton = wait.until(ExpectedConditions.elementToBeClickable(signupButton));
       signupbutton.click();
    }


}
