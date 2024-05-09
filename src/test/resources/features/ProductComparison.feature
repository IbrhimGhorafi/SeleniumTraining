Feature: Fortnums and Mason Product Comparison

  @ProductComparison
  Scenario Outline:User compares product details and quantities
    Given the user is on the Fortnums and Mason homepage
    And the user select the Non EU country switcher <country> and <currency>
    And the user click on search button
    When  the user fill the search field by <category>
    And the user hovers over the first product on the PLP
    And the user retrieves the name of the product
    And the user clicks on the "Add to Bag" button
    Then the user gets the title of the product from the cart
    And the user adds the quantity of the product from the cart
    And the user gets the price of a single product
    Then the user moves the element to the wish list
    And the user retrieves the quantity of the product from the wish list
    And the user compares the quantity

    Examples:
      | category        | country        | currency |
      | Royal Blend Tea | United Kingdom | € EUR    |