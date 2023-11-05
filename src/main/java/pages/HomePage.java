package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageBase {
    //locators
    private final By anyWhereBtn = By.cssSelector("[class=\"ffgcxut dir dir-ltr\"][data-index=\"0\"]");
    private final By rightRow = By.cssSelector("[aria-label=\"Move forward to switch to the next month.\"]>span");
    private final By whereField = By.id("bigsearch-query-location-input");
    private final By checkInBtn = By.cssSelector("[class=\"b1spesa7 b1fbhdca dir dir-ltr\"][data-testid=\"structured-search-input-field-split-dates-0\"]");
    private final By whoBtn = By.cssSelector("[class=\"b1spesa7 b1fbhdca b1889vka dir dir-ltr\"][data-testid=\"structured-search-input-field-guests-button\"]");
    private final By increaseAdults = By.cssSelector("[class=\"bv4zwx4 dir dir-ltr\"][data-testid=\"stepper-adults-increase-button\"]");
    private final By increaseChildren = By.cssSelector("[class=\"bv4zwx4 dir dir-ltr\"][data-testid=\"stepper-children-increase-button\"]");
    private final By searchBtn = By.cssSelector("[class=\"bhtghtc b1tqc7mb dir dir-ltr\"][data-testid=\"structured-search-input-search-button\"]");
    private final By headerGovernorate = By.xpath("(//div[@class=\"f16sug5q dir dir-ltr\"])[1]");
    private final By headerDate = By.xpath("(//div[@class=\"f16sug5q dir dir-ltr\"])[2]");
    private final By results = By.cssSelector("[class=\"tyi4kqb dir dir-ltr\"]");

    //variables
    //Constractor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //action
    public void ClickOnCheckInDate(String z) {
        impwait();
        boolean x = driver.findElement(anyWhereBtn).isDisplayed();
        impwait();
        if (x) {
            click1(anyWhereBtn);
            click1(whereField);
            driver.findElement(whereField).sendKeys(z);
        } else {
            impwait();
            click1(whereField);
            driver.findElement(whereField).sendKeys(z);
        }
        click1(checkInBtn);
        new HomePage(driver);

    }

    public void SelectCheckInDate() {
        impwait();
        String localDate1 = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        var checkInDay1 = By.cssSelector("[data-testid=\"calendar-day-" + localDate1);
        driver.findElement(checkInDay1).click();
        new HomePage(driver);
    }

    public void SelectCheckoutDateInDifferentMonths(int Days) {
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
        for (int i = currentMonthInt; i < checkOutMonthInt; i++) {
            impwait();
            driver.findElement(rightRow).click();
        }
        driver.findElement(checkOutDay2).click();
        new HomePage(driver);
    }

    public void AddGuests() {
        click1(whoBtn);
        click1(increaseAdults);
        click1(increaseAdults);
        click1(increaseChildren);
        click1(increaseChildren);
        click1(searchBtn);
        impwait();
        new HomePage(driver);
    }
    public boolean getGovernorateHeader (){
       return driver.findElement(headerGovernorate).getText().toLowerCase().contains("cairo");
    }

    public boolean getDateHeader (){
        return driver.findElement(headerDate).getText().toLowerCase().contains("nov 5 – 12");
    }
    public boolean getResults (){
        return driver.findElement(results).isDisplayed();
    }
}