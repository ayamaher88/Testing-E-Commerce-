package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;




public class AboutusPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By loginLink = By.xpath("//a [text()='Log in']");
    private By loginUsernameField = By.id("loginusername");
    private By loginPasswordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By AboutusButton = By.xpath("//a[text()='About us']");
    private By CloseAboutusButton = By.xpath("/html/body/div[4]/div/div/div[3]/button");

  // private By CloseAboutusButton = By.xpath("//div[@class='modal-footer']/button[@class='btn btn-secondary' and @data-dismiss='modal' and text()='Close']");


    // Constructor
    public AboutusPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Actions
    public void clickLoginlink() {
        WebElement loginLinkElement = wait.until((ExpectedConditions.elementToBeClickable(loginLink)));
        loginLinkElement.click();
    }

    public void enterLoginUsername(String username) {
        WebElement loginusernamefield = wait.until(ExpectedConditions.elementToBeClickable(loginUsernameField));
        loginusernamefield.sendKeys(username);
    }

    public void enterLoginpassword(String password) {
        WebElement loginpasswordfield = wait.until(ExpectedConditions.elementToBeClickable(loginPasswordField));
        loginpasswordfield.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement LoginButton = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        LoginButton.click();
    }
    public void clickaboutusButton() {
        WebElement aboutusButton = wait.until(ExpectedConditions.elementToBeClickable(AboutusButton));
        aboutusButton.click();
    }
    public void clickcloseaboutusButton() {
        WebElement closeaboutusButton = wait.until(ExpectedConditions.elementToBeClickable(CloseAboutusButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeaboutusButton);
        //closeaboutusButton.click();
    }

}
