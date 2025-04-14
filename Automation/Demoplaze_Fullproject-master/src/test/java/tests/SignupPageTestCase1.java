package tests;
import Pages.SignupPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class SignupPageTestCase1 extends BaseTest {
    @DataProvider(name = "signupdata")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet1";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "signupdata")
    public void testlogin(String username, String password) {
        SignupPage signupPage = new SignupPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on signuplink
        signupPage.clicksignuplink();
        //2-Enter Username
        signupPage.entersignupUsername(username);
        //3-EnterPassword
        signupPage.entersignuppassword(password);
        //4-Click on signup button
        signupPage.clicksignupButton();

        //6-Verify the URL
        String expectedUrl="https://www.demoblaze.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals((actualUrl),expectedUrl,"URL is not as expected ");


    }





}
