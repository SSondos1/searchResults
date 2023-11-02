package java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HomePage extends PageBase {
    //locators
    private final By anyWhereBtn = By.xpath("(//button[@class=\"ffgcxut dir dir-ltr\"])[1]");
    private final By checkInBtn = By.xpath("(//div[@class=\"lc92ud4 dir dir-ltr\"])[1]");
    private final By checkInBtn2 = By.xpath("(//div[@class=\"c1nxe26m dir dir-ltr\"])[1]");
    private final By rightRow = By.cssSelector("[aria-label=\"Move forward to switch to the next month.\"]>span");
    //variables
    //Constractor
    public HomePage(WebDriver driver) {
        super(driver);
    }
    //action
    public void ClickOnCheckInDate() {
        impwait();
      boolean x = driver.findElement(anyWhereBtn).isDisplayed();
        if (x){
            driver.findElement(anyWhereBtn).click();
            impwait();
            driver.findElement(checkInBtn).click();
        }
        else {
            impwait();
            driver.findElement(checkInBtn2).click();
        }
        new HomePage(driver);
    }
    public void SelectCheckInDate() {
        impwait();
        String localDate1 = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        var checkInDay1 = By.cssSelector("[data-testid=\"calendar-day-" + localDate1);
       driver.findElement(checkInDay1).click();
        new HomePage(driver);
    }
    public void SelectCheckoutDateInDifferentMonths (int Days) {
        impwait();
        String localDate3 = LocalDate.now().plusDays(Days).format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        var checkOutDay2 = By.cssSelector("[data-testid=\"calendar-day-" + localDate3);
        LocalDate localDate = LocalDate.now();
        String currentMonthStr = localDate.getMonth().toString().toLowerCase();
        String checkOutMonthStr = localDate.getMonth().toString().toLowerCase();
        int currentMonthInt = switch (currentMonthStr) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };

        int checkOutMonthInt = switch (checkOutMonthStr) {
            case "january" -> 1;
            case "february" -> 2;
            case "march" -> 3;
            case "april" -> 4;
            case "may" -> 5;
            case "june" -> 6;
            case "july" -> 7;
            case "august" -> 8;
            case "september" -> 9;
            case "october" -> 10;
            case "november" -> 11;
            case "december" -> 12;
            default -> 0;
        };
        for (int i = currentMonthInt;i <checkOutMonthInt ; i++){
            impwait();
            driver.findElement(rightRow).click();
        }
        driver.findElement(checkOutDay2).click();
        new HomePage(driver);
    }
}
