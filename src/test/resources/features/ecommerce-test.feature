Feature: Adding Items to Wish list and then to Cart
  As A customer
  I should add items to wishlist and cart
  So that I can checkout from cart for payment

  Scenario: Verify that lowest priced item from Wish list could be added to cart
    Given I add four different products to my wishlist
    When I view my wishlist table
    Then I find total four selected items in my wishlist
    When I search for lowest price product
    And I am able to add the lowest price item to my cart
    Then I am able to verify the item in my cart