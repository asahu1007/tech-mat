import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class TestUtility {
    WebDriver driver;

    public  TestUtility(WebDriver drv){
        driver = drv;
    }
    //Search Product method to trigger Product search based on the passed Search string as argument
    public void searchProduct(String searchStr){
        WebElement prodSrchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        prodSrchBox.clear();
        prodSrchBox.sendKeys(searchStr);
        WebElement searchSubmit = driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button"));
        searchSubmit.submit();
    }

    //Sort Product method to trigger sorting filter, sorting type to be passed as an argument
    public void sortProduct(String sortBy){
        Integer sortIndex;
        if(sortBy == "Relevancy"){
            sortIndex = 1;
        }else if (sortBy == "Top Customer Reviews"){
            sortIndex = 2;
        }else if (sortBy == "Highest Price"){
            sortIndex = 3;
        }else if (sortBy == "Lowest Price"){
            sortIndex = 4;
        }else{
            return;
        }
        driver.findElement(By.xpath("//*[@id=\"sortby\"]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"sortby\"]/div/a[" + sortIndex + "]")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        WebElement cookiesSelectBar = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/li[1]/div/a")));
    }

    //Add Product to cart and Close the tab
    public void addProductToCartnClose(Integer prodNum){
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        String xPathDynamic = "//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/li[" + prodNum;
        xPathDynamic = xPathDynamic + "]/div/div/a";
        WebElement waitForProdLoad = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathDynamic)));
        driver.findElement(By.xpath(xPathDynamic)).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div/div[5]/div/form/button")).submit();
        driver.close();
        driver.switchTo().window(winHandleBefore);
        driver.navigate().refresh();
    }
    //Add Product to Cart
    public void addProductToCart(Integer prodNum){
        WebDriverWait wait1 = new WebDriverWait(driver, 20);
        String xPathDynamic = "//*[@id=\"content\"]/div/div[1]/div/div/div[2]/div[2]/div[3]/div/div[1]/div/li[" + prodNum;
        xPathDynamic = xPathDynamic + "]/div/a";
        WebElement waitForProdLoad = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xPathDynamic)));
        driver.findElement(By.xpath(xPathDynamic)).click();
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div/div[5]/div/form/button")).submit();

    }
    //Validate the number of items in cart with the expected value passed as argument
    public void ValidateCartCount(Integer expectedCount){
        List<WebElement> allItemsInCart = driver.findElements(By.xpath("//*[@id=\"multi-shop-cart-list\"]/div/div/div[1]/ul/li"));
        Integer cartCountOnWebsite = allItemsInCart.size();
        Assert.assertEquals(expectedCount, cartCountOnWebsite);
    }
}
