package tests;
import Pages.ContactPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ExcelReader;
import java.io.IOException;
import java.time.Duration;

public class ContactPageTestCase4 extends BaseTest {
    @DataProvider(name = "invaildcontactinformation")
    public Object[][] logindata() throws IOException {
        String sheetName = "Sheet17";
        return ExcelReader.getlogindata(sheetName);
    }
    @Test(dataProvider = "invaildcontactinformation")
    public void testlogin(String name, String email,String message) {
        ContactPage contactPage = new ContactPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //1-Click on contactlink
        contactPage.clickcontactlink();
        //2-Enter contactemail
        contactPage.enterercontactemail(email);
        //3-Entercontactname
        contactPage.entercontactname(name);
        //4-enter message
        contactPage.messagearea(message);

        //5-cLICK ON sendmessage button

        contactPage.clicksendButton();

    }
}
