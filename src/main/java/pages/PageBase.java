package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class PageBase {
    WebDriver driver;
    public PageBase(WebDriver driver){
        this.driver = driver;
    }
    public Actions actions(){
        return new Actions(driver);
    }
    public  WebDriverWait expwait(){
        WebDriverWait wait;
        wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        return wait;
    }
    public void impwait(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

    }
    public PageBase insertText(By locator,String text){
        WebElement webElement = driver.findElement(locator);
        expwait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
        return new PageBase(driver);
    }
    public void click1(By locator){
        WebElement webElement = driver.findElement(locator);
        expwait().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
        new PageBase(driver);
    }
    public WebElement fluentWait(WebDriver driver, final By locator, int timeoutSeconds, int pollingIntervalMillis) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingIntervalMillis))
                .ignoring(NoSuchElementException.class);

        WebElement element;
        element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });

        return element;
    }
    public ArrayList<String> arrylist() {
        ArrayList<String> Tabs = new ArrayList<>(driver.getWindowHandles());
        return Tabs;
    }

    }

