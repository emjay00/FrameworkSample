import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;
import org.testng.annotations.Test;
import java.io.IOException;

public class HomePage extends Base {
    public static Logger log = LogManager.getLogger(Base.class.getName());
    @BeforeTest
    public void initialize() throws IOException {
        driver= initDriver();
        log.info("Driver initialised");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Pass){
        driver.get("https://www.qaclickacademy.com/");
        log.info("Homepage loaded");
        LandingPage landingPage=new LandingPage(driver);
        if(landingPage.getPopupSize()>0){
            landingPage.getPopup().click();
        }
        LoginPage loginPage=landingPage.getLogin();
        loginPage.getEmail().sendKeys(Username);
        loginPage.getPass().sendKeys(Pass);
        //System.out.println(text);
        loginPage.getLogin().click();
        log.info("Credentials entered");
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data= new Object[2][2];

        //0th row
        data[0][0]="haha@ha.com";
        data[0][1]="hahahaha";
        //data[0][2]="Restricted user";

        //1st row
        data[1][0]="jaja@ja.com";
        data[1][1]="jajajaja";
        //data[1][2]="Nonrestricted user";
        return data;
    }

}
