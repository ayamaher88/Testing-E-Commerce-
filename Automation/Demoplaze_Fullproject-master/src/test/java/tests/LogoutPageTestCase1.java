package tests;
import Pages.LoginPage;
import Pages.LogoutPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class LogoutPageTestCase1 extends BaseTest {
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "logindata")
    public void testlogin(String username, String password) {
        LogoutPage logoutPage= new LogoutPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on loginlink
        logoutPage.clickLoginlink();
        //2-Enter Username
        logoutPage.enterLoginUsername(username);
        //3-EnterPassword
        logoutPage.enterLoginpassword(password);
        //4-Click on login button
        logoutPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));

        //6-Verify the URL
        String expectedUrl="https://www.demoblaze.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl),expectedUrl,"URL is not as expected ");

        //7-Click on logout link
        logoutPage.clickLogoutlink();


    }}