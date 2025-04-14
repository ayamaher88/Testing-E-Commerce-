package tests;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class HomePageTestCase4 extends BaseTest {
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "logindata")
    public void testlogin(String username, String password) {
        HomePage homePage= new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on loginlink
        homePage.clickLoginlink();
        //2-Enter Username
        homePage.enterLoginUsername(username);
        //3-EnterPassword
        homePage.enterLoginpassword(password);
        //4-Click on login button
        homePage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
        //5-cLICK ON phone section

        homePage.clickPhoneslink();
        WebElement phonesTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Samsung galaxy s6']")));
        Assert.assertTrue(phonesTitle.isDisplayed(), "Phones  section title is not displayed.");
        //6-click on the product details
        homePage.clickphoneproduct();

        //7-Verify the URL
        String expectedUrl="https://www.demoblaze.com/prod.html?idp_=1";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl),expectedUrl,"URL is not as expected ");
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));
        //8- Click on the Homelink
        homePage.gotohomepage();
        //9-click on laptopssection
        homePage.clicklabtopslink();
        WebElement laptopsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='prod.html?idp_=8'and @class='hrefch']")));
        Assert.assertTrue(laptopsTitle.isDisplayed(), "Laptops section title is not displayed.");


        //6-Verify the URL
        String expectedUrl1="https://www.demoblaze.com/index.html#";
        String actualUrl1=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl1),expectedUrl1,"URL is not as expected ");
        //10-click on the laptop product details
        homePage.clicklaptoproduct();
        //11-verify url
        String expectedUrl2="https://www.demoblaze.com/prod.html?idp_=8";
        String actualUrl2=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl2),expectedUrl2,"URL is not as expected ");
        WebElement productTitle2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));
        //12-Click on the Home link
        homePage.gotohomepage();
        //13-click on monitorssection
        homePage.clickmonitorslink();
        WebElement monitorsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='prod.html?idp_=10'and @class='hrefch']")));
        Assert.assertTrue(monitorsTitle.isDisplayed(), "montitors section title is not displayed.");



        //6-Verify the URL
        String expectedUrl3="https://www.demoblaze.com/index.html#";
        String actualUrl3=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl3),expectedUrl3,"URL is not as expected ");
        //14-click on the monitor product details
        homePage.clickmonitorproduct();
        //15 verify url
        String expectedUrl4="https://www.demoblaze.com/prod.html?idp_=10";
        String actualUrl4=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl4),expectedUrl4,"URL is not as expected ");
        WebElement productTitle3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='name']")));
        //16-click on the home page
        homePage.gotohomepage();






    }





}
