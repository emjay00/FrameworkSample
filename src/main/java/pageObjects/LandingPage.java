package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }
    By logIn = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
    By popup= By.xpath("//*[@id=\"homepage\"]/div[4]/div[2]/div/div/div/span/div/div[6]/div/div/button");
    //validate with title- Assert.Equals
    By title= By.xpath("//*[@id=\"content\"]/div/div/h2");

    public WebElement getPopup(){
        return driver.findElement(popup);
    }

    public int getPopupSize(){
        return driver.findElements(popup).size();
    }
    public LoginPage getLogin() {
        driver.findElement(logIn).click();

        LoginPage loginPage=new LoginPage(driver);
        return loginPage;
    }

}
