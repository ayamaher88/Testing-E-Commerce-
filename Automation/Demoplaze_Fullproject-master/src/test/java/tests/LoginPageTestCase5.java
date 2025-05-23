package tests;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class LoginPageTestCase5 extends BaseTest {
    @DataProvider(name = "invalidpasswordandusername")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet10";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "invalidpasswordandusername")
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

