package testClasses;

import io.qameta.allure.Allure;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import org.testng.asserts.SoftAssert;

public class HomePageTests {
    WebDriver driver;
    HomePage homePage;
    SoftAssert softAssert;
    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
         softAssert = new SoftAssert();
        driver.get("https://www.airbnb.com/");
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void selectDateInOtherMonth() throws InterruptedException {
        Thread.sleep(5000);
        homePage.ClickOnCheckInDate("Cairo Governorate, Egypt");
        Thread.sleep(5000);
        homePage.SelectCheckInDate();
        Thread.sleep(5000);
        homePage.SelectCheckoutDateInDifferentMonths(7);
        Thread.sleep(5000);
        homePage.AddGuests();
        Thread.sleep(5000);
       softAssert.assertTrue(homePage.getGovernorateHeader());
       softAssert.assertTrue(homePage.getDateHeader());
       softAssert.assertTrue(homePage.getResults());

      softAssert.assertAll();
    }
   @AfterTest
     public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
     driver.quit();
     }
}
