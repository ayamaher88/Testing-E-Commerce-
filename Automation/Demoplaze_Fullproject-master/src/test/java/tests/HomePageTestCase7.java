package tests;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class HomePageTestCase7 extends BaseTest {
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "logindata")
    public void testlogin(String username, String password) {
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By initialSlideLocator = By.xpath("//img[@alt='First slide']");
        By secondSlideLocator = By.xpath("//img[@alt='Second slide']");
        By thirdSlideLocator = By.xpath("//img[@class='d-block img-fluid' and @alt='Third slide']");


        //1-Click on loginlink
        homePage.clickLoginlink();
        //2-Enter Username
        homePage.enterLoginUsername(username);
        //3-EnterPassword
        homePage.enterLoginpassword(password);
        //4-Click on login button
        homePage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
        //5-click on the right carousel (first click)
        WebElement currentCarouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(initialSlideLocator));
        System.out.println("First Slide Visible " + wait.until(ExpectedConditions.visibilityOfElementLocated(initialSlideLocator)).isDisplayed());
        System.out.println("Right Carousel Element Found: " + driver.findElement(homePage.getClickonRIGHTcarousel()).isDisplayed());
        homePage.Clickrightcarousel();
        //6-click on the right carousel (second click)
        currentCarouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(secondSlideLocator));
        System.out.println("Second Slide Visible After Right Click: " + wait.until(ExpectedConditions.visibilityOfElementLocated(secondSlideLocator)).isDisplayed());
        System.out.println("Right Carousel Element Found: " + driver.findElement(homePage.getClickonRIGHTcarousel()).isDisplayed());
        homePage.Clickrightcarousel();
        currentCarouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(thirdSlideLocator));
        System.out.println("Third Slide Visible After Right Click: " + wait.until(ExpectedConditions.visibilityOfElementLocated(thirdSlideLocator)).isDisplayed());

       // 7-click on the left carousel (first click)
        System.out.println("Left Carousel Element Found: " + driver.findElement(homePage.getCLICKonLEFTcarousel()).isDisplayed());
        homePage.Clickleftcarousel();

        //8-CLICK ON THE LEFT CAROUSEL (SECOND CLICK)
        currentCarouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(secondSlideLocator));
        System.out.println("Second  Slide Visible After Right Click: " + wait.until(ExpectedConditions.visibilityOfElementLocated(secondSlideLocator)).isDisplayed());
        System.out.println("Left Carousel Element Found: " + driver.findElement(homePage.getCLICKonLEFTcarousel()).isDisplayed());
        homePage.Clickleftcarousel();
        currentCarouselElement = wait.until(ExpectedConditions.visibilityOfElementLocated(initialSlideLocator));
        System.out.println("First Slide Visible After Left Click: " + wait.until(ExpectedConditions.visibilityOfElementLocated(initialSlideLocator)).isDisplayed());


    }}