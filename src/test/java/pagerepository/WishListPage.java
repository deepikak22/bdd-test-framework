package pagerepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WishListPage {


    private static final String WISHLIST_ITEM_ELEMENTS_LOCATOR = "//tbody[@class='wishlist-items-wrapper']/tr";
    private static final String WISHLIST_ITEM_PRICE_ELEMENT_LOCATOR = "descendant::td[@class=\"product-price\"]//ins/span[@class='woocommerce-Price-amount amount']" +
            "|descendant::td[@class=\"product-price\"]/span[@class='woocommerce-Price-amount amount']";
    private static final String ADD_TO_CART_ELEMENT_LOCATOR = "descendant::a[text()='Add to cart']";
    private static final String ITEM_COUNT_IN_CART_ELEMENT_LOCATOR = "//div[@class='site-header container-fluid']//i[@class='la la-shopping-bag']/span[@class='count']";


    public List<WebElement> getWishListItems(WebDriver driver) {
        List<WebElement> wishListProductElements = driver.findElements(By.xpath(WISHLIST_ITEM_ELEMENTS_LOCATOR));
        return wishListProductElements;
    }

    public int getWishListItemsCount(WebDriver driver) {
        int itemCount = getWishListItems(driver).size();
        return itemCount;
    }

    public WebElement getLowestPricedItem(WebDriver driver) {
        List<WebElement> wishListProductElements = getWishListItems(driver);
        WebElement leastPricedElement = wishListProductElements.get(0);
        Double leastPrice = Double.parseDouble(leastPricedElement.findElement(By.xpath(WISHLIST_ITEM_PRICE_ELEMENT_LOCATOR)).getText().substring(1));
        for (WebElement wishListProductElement : wishListProductElements) {
            WebElement priceElement = wishListProductElement.findElement(By.xpath(WISHLIST_ITEM_PRICE_ELEMENT_LOCATOR));
            Double itemPrice = Double.parseDouble(priceElement.getText().substring(1));
            System.out.println(itemPrice);
            if (itemPrice < leastPrice) {
                leastPrice = itemPrice;
                leastPricedElement = wishListProductElement;
            }
        }
        return leastPricedElement;
    }

    public void addLowestPricedItemToCart(WebElement leastPricedElement) {
        WebElement addToCartElement = leastPricedElement.findElement(By.xpath(ADD_TO_CART_ELEMENT_LOCATOR));
        addToCartElement.click();
    }

    public boolean isItemAddedToCart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.textToBe(By.xpath(ITEM_COUNT_IN_CART_ELEMENT_LOCATOR), "1"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
