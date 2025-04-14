package tests;
import Pages.AboutusPage;
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

public class AboutusPageTestCase1 extends BaseTest {
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "logindata")
    public void testlogin(String username, String password) {
        AboutusPage aboutusPage = new AboutusPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on loginlink
        aboutusPage.clickLoginlink();
        //2-Enter Username
        aboutusPage.enterLoginUsername(username);
        //3-EnterPassword
        aboutusPage.enterLoginpassword(password);
        //4-Click on login button
        aboutusPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
        //5-cLICK ON aboutus  section

        aboutusPage.clickaboutusButton();
        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='videoModalLabel']")));
        Assert.assertTrue(pageTitle.isDisplayed(), "about us section title is not displayed.");

        //6-Verify the URL
        String expectedUrl = "https://www.demoblaze.com/index.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals((actualUrl), expectedUrl, "URL is not as expected ");


        // 7-Click on the close button
        aboutusPage.clickcloseaboutusButton();


         }
}


