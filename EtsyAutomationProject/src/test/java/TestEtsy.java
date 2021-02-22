import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestEtsy {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.etsy.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement cookiesSelectBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button")));
        driver.findElement(By.xpath("//*[@id=\"gdpr-single-choice-overlay\"]/div/div[2]/div[2]/button")).click();
    }

    @Test
    public void mainTest() {
        TestUtility testUtilObj = new TestUtility(driver);
        testUtilObj.searchProduct("Sketchbook");
        testUtilObj.sortProduct("Highest Price");
        testUtilObj.addProductToCartnClose(6);
        testUtilObj.searchProduct("turntable mat");
        testUtilObj.addProductToCart(1);
        testUtilObj.ValidateCartCount(2);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }



}
