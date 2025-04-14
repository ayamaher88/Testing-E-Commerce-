package tests;
import Pages.CartPage;
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

public class CartPageTestCase3 extends BaseTest {
    @DataProvider(name = "logindata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet0";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "logindata")
    public void testlogin(String username, String password) {
        CartPage cartPage = new CartPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on loginlink
        cartPage.clickLoginlink();
        //2-Enter Username
        cartPage.enterLoginUsername(username);
        //3-EnterPassword
        cartPage.enterLoginpassword(password);
        //4-Click on login button
        cartPage.clickLoginButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nameofuser']")));
        //5-click on  the product
        cartPage.clickcartButton();
        // 6- click on delete product
        cartPage.clickdeleteproductbutton();

        WebElement pageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Products']")));
        Assert.assertTrue(pageTitle.isDisplayed(), "about us section title is not displayed.");

        //7-Verify the URL
        String expectedUrl = "https://www.demoblaze.com/cart.html#";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals((actualUrl), expectedUrl, "URL is not as expected ");
        //




    }}