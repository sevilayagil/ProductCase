Feature: Product feature

  Background:
    Given user is at landing page for the login process
    When user sign in website
    Then user shows homepage

  Scenario: User search product and do shopping process successfully
    When user search products
    And user open second page and selects one product
    Then user adds product to cart
    And user controls accuracy of product price in basket
    And user increases the product quantity and sees that the number of products is 2
    And user deletes the product from the basket and checks that the basket is empty.
