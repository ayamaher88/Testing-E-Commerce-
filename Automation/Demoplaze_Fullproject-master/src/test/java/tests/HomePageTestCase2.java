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

public class HomePageTestCase2 extends BaseTest {
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
        //Wait for the element to be clickable
        // and then click on it
        homePage.clickLoginButton();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));


        //5-cLICK ON LAbTOPS section
        homePage.clicklabtopslink();
        WebElement laptopsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='prod.html?idp_=8'and @class='hrefch']")));
        Assert.assertTrue(laptopsTitle.isDisplayed(), "Laptops section title is not displayed.");


        //6-Verify the URL
        String expectedUrl="https://www.demoblaze.com/index.html#";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl),expectedUrl,"URL is not as expected ");
       //7-Get the list of laptops
        

    }





}
