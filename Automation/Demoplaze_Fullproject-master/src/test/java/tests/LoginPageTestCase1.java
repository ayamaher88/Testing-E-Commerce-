package tests;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class LoginPageTestCase1 extends BaseTest {
    @DataProvider(name = "unregisterusername")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet8";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "unregisterusername")
    public void testlogin(String username, String password) {
        LoginPage loginPage= new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on loginlink
        loginPage.clickLoginlink();
        //2-Enter Username
        loginPage.enterLoginUsername(username);
        //3-EnterPassword
        loginPage.enterLoginpassword(password);
        //4-Click on login button
        loginPage.clickLoginButton();

    }





}

