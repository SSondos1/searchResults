package java.testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests {
    WebDriver driver;
    HomePage homePage;
    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void selectDateInOtherMonth(){
        homePage.ClickOnCheckInDate();
        homePage.SelectCheckInDate();
        homePage.SelectCheckoutDateInDifferentMonths(7);
    }
   @AfterTest
     public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
       driver.quit();
     }
}
