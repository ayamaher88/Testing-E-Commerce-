package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By loginLink = By.xpath("//a [text()='Log in']");
    private By loginUsernameField = By.id("loginusername");
    private By loginPasswordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By CartButton = By.xpath("// a[text()='Cart']");
    private  By CLICKONPRODUCTLINK=By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Samsung galaxy s6']");
    private  By addToCartButton=By.xpath("//a[text()='Add to cart']");
    private  By Deleteproductbutton=By.xpath("  //a[text()='Delete']");


    // Constructor
    public CartPage(WebDriver driver) {
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
    public void clickcartButton() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(CartButton));
       cartButton.click();
    }
    public void clickonproduct() {
        WebElement PRODUCTLINK = wait.until(ExpectedConditions.elementToBeClickable(CLICKONPRODUCTLINK));
       //((JavascriptExecutor) driver).executeScript("arguments[0].click();", PRODUCTLINK);
        PRODUCTLINK.click();
    }
    public void clickaddtocartbutton() {
        WebElement addtocart = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocart);
        addtocart.click();
    }
    public void clickdeleteproductbutton() {
        WebElement deleteproduct = wait.until(ExpectedConditions.elementToBeClickable(Deleteproductbutton));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", addtocart);
        deleteproduct.click();
    }

}