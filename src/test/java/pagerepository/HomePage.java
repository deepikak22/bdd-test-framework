package pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    private static final String ACCEPT_ALL_COOKIES_ELEMENT_LOCATOR = "//a[text()='Accept all']";
    private static final String ADD_TO_WISHLIST_ELEMENT_LOCATOR = "//span[text()='Add to wishlist']";
    private static final String PRODUCT_ADDED_MSG_ELEMENT_LOCATOR = "//div[@id='yith-wcwl-popup-message']/div[text()='Product added!']";
    private static final String WISH_LIST_ELEMENT_LOCATOR = "//div[@class='header-wishlist']/a";

    public void acceptAllCookies(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ACCEPT_ALL_COOKIES_ELEMENT_LOCATOR))).click();
    }

    public void addProductsToWishList(WebDriver driver) {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        List<WebElement> addToWishListButtons = driver.findElements(By.xpath(ADD_TO_WISHLIST_ELEMENT_LOCATOR));

        addToWishListButtons.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));

        addToWishListButtons.get(4).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));

        actions.moveToElement(addToWishListButtons.get(5)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));

        actions.moveToElement(addToWishListButtons.get(6)).click().build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(PRODUCT_ADDED_MSG_ELEMENT_LOCATOR)));
    }

    public void clickWishListElement(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(WISH_LIST_ELEMENT_LOCATOR))).click();
    }
}
