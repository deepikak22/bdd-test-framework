package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pagerepository.HomePage;
import pagerepository.WishListPage;
import utils.PropertiesReader;
import utils.DriverManager;

public class Steps {

    WebDriver driver;
    DriverManager driverManager = new DriverManager();
    HomePage homePage = new HomePage();
    WishListPage wishListPage = new WishListPage();
    WebElement lowestPricedItemElement;

    @Before
    public void setUpBrowser() {
        driver = driverManager.getWebDriver(PropertiesReader.readPropertyValue("browser"));
        driver.get(PropertiesReader.readPropertyValue("url"));
        homePage.acceptAllCookies(driver);
    }

    @After
    public void cleanUpBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I add four different products to my wishlist")
    public void i_add_four_different_products_to_my_wishlist() {
        homePage.addProductsToWishList(driver);
    }

    @When("I view my wishlist table")
    public void i_view_my_wishlist_table() {
        homePage.clickWishListElement(driver);
    }

    @Then("I find total four selected items in my wishlist")
    public void i_find_total_four_selected_items_in_my_wishlist() {
        int actualItemCount = wishListPage.getWishListItemsCount(driver);
        int expectedItemCount = 4;
        Assert.assertEquals(actualItemCount, expectedItemCount, "Items are not in Wish list.");
    }

    @When("I search for lowest price product")
    public void i_search_for_lowest_price_product() {
        lowestPricedItemElement = wishListPage.getLowestPricedItem(driver);
    }

    @When("I am able to add the lowest price item to my cart")
    public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
        wishListPage.addLowestPricedItemToCart(lowestPricedItemElement);
    }

    @Then("I am able to verify the item in my cart")
    public void i_am_able_to_verify_the_item_in_my_cart() {
        boolean isItemInCart = wishListPage.isItemAddedToCart(driver);
        Assert.assertTrue(isItemInCart, "Item is not in the cart.");
    }
}
