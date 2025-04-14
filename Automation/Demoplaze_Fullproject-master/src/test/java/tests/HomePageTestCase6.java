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

public class HomePageTestCase6 extends BaseTest {
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
        //6-click on next button
        homePage.Clicknextbutton();
        WebElement productNAME1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
        Assert.assertTrue (productNAME1.isDisplayed(),"product name is not displayed ");

        //7-clcik on prevoius button
        homePage.Clickpreviousbutton();
        WebElement productNAME2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Nokia lumia 1520']")));
        Assert.assertTrue (productNAME2.isDisplayed(),"product name is not displayed ");

        //8-GO TO LAPTOPS SECTION AND CLICK ON NEXT,PREVIOUS BUTTONS
        homePage.clicklabtopslink();
        WebElement laptopsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='prod.html?idp_=8'and @class='hrefch']")));
        Assert.assertTrue(laptopsTitle.isDisplayed(), "Laptops section title is not displayed.");
        //Verify the URL
        String expectedUrl1="https://www.demoblaze.com/index.html#";
        String actualUrl1=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl1),expectedUrl1,"URL is not as expected ");
        //click on next button
        homePage.Clicknextbutton();
        WebElement productNAME3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='MacBook air']")));
        Assert.assertTrue (productNAME3.isDisplayed(),"product name is not displayed ");

        //clcik on prevoius button
        homePage.Clickpreviousbutton();
        WebElement productNAME4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Nokia lumia 1520']")));
        Assert.assertTrue (productNAME4.isDisplayed(),"product name is not displayed ");

        //9-GO TO MONITORS SECTION AND CLICK ON NEXT ,PREVIOUS BUTTONS
        homePage.clickmonitorslink();
        WebElement monitorTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='prod.html?idp_=10'and @class='hrefch']")));
        Assert.assertTrue(monitorTitle.isDisplayed(), "Laptops section title is not displayed.");
        //Verify the URL
        String expectedUrl2="https://www.demoblaze.com/index.html#";
        String actualUrl2=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl2),expectedUrl2,"URL is not as expected ");
        //click on next button
        homePage.Clicknextbutton();
        WebElement productNAME5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='MacBook air']")));
        Assert.assertTrue (productNAME5.isDisplayed(),"product name is not displayed ");

        //clcik on prevoius button
        homePage.Clickpreviousbutton();
        WebElement productNAME6 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']/a[@class='hrefch' and text()='Nokia lumia 1520']")));
        Assert.assertTrue (productNAME6.isDisplayed(),"product name is not displayed ");





    }}
