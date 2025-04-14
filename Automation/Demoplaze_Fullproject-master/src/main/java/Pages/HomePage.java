package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    //locators
    private By loginLink = By.xpath("//a [text()='Log in']");
    private By loginUsernameField = By.id("loginusername");
    private By loginPasswordField = By.id("loginpassword");
    private By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    private By Phonessectionlink = By.xpath("//a[@id='itemc' and @class='list-group-item' and text()='Phones']");
    private By Labtopsectionlink = By.xpath("//a[@id='itemc' and @class='list-group-item' and text()='Laptops']");
    private By Monitorssectionlink = By.xpath("//a[@id='itemc' and @class='list-group-item' and text()='Monitors']");
    private By PhoneProductDetails = By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Samsung galaxy s6']");
    private By LaptopsProductDetails = By.xpath("//a[@href='prod.html?idp_=8'and @class='hrefch']");
    private By MonitorsProductDetails = By.xpath("//a[@href='prod.html?idp_=10'and @class='hrefch']");
    private By Gobaccktohomepage = By.xpath(("//a[@class='nav-link' and @href='index.html']"));
    private By ClickonThelogoproductstore = By.xpath("//a[@id='nava']");
    private By CLICKonNextButton = By.xpath("//button[@id='next2']");
    private By CLICKonPrevoiusButton = By.xpath(("//button[@id='prev2']"));
    private By ClickonRIGHTcarousel=By.xpath("//a[@class='carousel-control-next']");
    private By CLICKonLEFTcarousel=By.xpath(("//a[@class='carousel-control-prev']"));


    // Constructor
    public HomePage(WebDriver driver) {
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

    public void clickPhoneslink() {
        WebElement PhoneLinkElement = wait.until((ExpectedConditions.elementToBeClickable(Phonessectionlink)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PhoneLinkElement);
    }

    public void clicklabtopslink() {
        WebElement LaptopsLinkElement = wait.until((ExpectedConditions.elementToBeClickable(Labtopsectionlink)));
        // LaptopsLinkElement.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", LaptopsLinkElement);
    }

    public void clickmonitorslink() {
        WebElement MonitorsLinkElement = wait.until((ExpectedConditions.elementToBeClickable(Monitorssectionlink)));
        MonitorsLinkElement.click();

    }

    public void clickphoneproduct() {
        WebElement phoneproductLinkElement = wait.until((ExpectedConditions.elementToBeClickable(PhoneProductDetails)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", phoneproductLinkElement);


    }

    public void clicklaptoproduct() {
        WebElement laptopproductLinkElement = wait.until((ExpectedConditions.elementToBeClickable(LaptopsProductDetails)));
       // ((JavascriptExecutor) driver).executeScript("arguments[0].click();", laptopproductLinkElement);
        laptopproductLinkElement.click();


    }

    public void clickmonitorproduct() {
        WebElement monitorproductLinkElement = wait.until((ExpectedConditions.elementToBeClickable(MonitorsProductDetails)));
        monitorproductLinkElement.click();


    }

    public void gotohomepage() {
        WebElement homepageLinkElement = wait.until((ExpectedConditions.elementToBeClickable(Gobaccktohomepage)));
        homepageLinkElement.click();


    }

    public void Clickonlogo() {
        WebElement homepageLinkElement = wait.until((ExpectedConditions.elementToBeClickable(ClickonThelogoproductstore)));
        homepageLinkElement.click();


    }

    public void Clicknextbutton() {
        WebElement nextbutton = wait.until((ExpectedConditions.elementToBeClickable(CLICKonNextButton)));
        nextbutton.click();

    }
    public void Clickpreviousbutton() {
        WebElement previosbutton = wait.until((ExpectedConditions.elementToBeClickable(CLICKonPrevoiusButton)));
        previosbutton.click();
    }
    public void Clickrightcarousel() {
        WebElement rightcarousel = wait.until((ExpectedConditions.elementToBeClickable(ClickonRIGHTcarousel)));
        //rightcarousel.click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", rightcarousel);

    }
    public void Clickleftcarousel() {
        WebElement leftcarousel = wait.until((ExpectedConditions.elementToBeClickable(CLICKonLEFTcarousel)));
       // leftcarousel.click();

       ((JavascriptExecutor) driver).executeScript("arguments[0].click();",leftcarousel);

    }
    public By getClickonRIGHTcarousel() {
        return ClickonRIGHTcarousel;
    }

    public By getCLICKonLEFTcarousel() {
        return CLICKonLEFTcarousel;
    }
}
