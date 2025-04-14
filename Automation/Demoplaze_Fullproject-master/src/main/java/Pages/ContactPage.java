package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By contactLink = By.xpath("//a[text()='Contact']");
    private By contactemailField = By.xpath("//input[@id='recipient-email']");
    private By contactnameField = By.xpath("//input[@id='recipient-name']");
    private By messagearea = By.xpath("//textarea[@id='message-text']");
    private By SendmessageButton = By.xpath("//button[text()='Send message']");

    // Constructor
    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public void clickcontactlink() {
        WebElement contactLinkElement = wait.until((ExpectedConditions.elementToBeClickable(contactLink)));
        contactLinkElement.click();
    }

    public void enterercontactemail(String email) {
        WebElement contactemailfield = wait.until(ExpectedConditions.elementToBeClickable(contactemailField));
        contactemailfield.sendKeys(email);
    }

    public void entercontactname(String name) {
        WebElement contactnamefield = wait.until(ExpectedConditions.elementToBeClickable(contactnameField));
        contactnamefield.sendKeys(name);
    }

    public void messagearea(String message) {
        WebElement Messagearea = wait.until(ExpectedConditions.elementToBeClickable(messagearea));
        Messagearea.sendKeys(message);
    }
    public void clicksendButton() {
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(SendmessageButton));
        sendButton.click();
    }

}
