Feature: Shopping Cart Calculation

  Scenario: Calculate Cart Subtotal and Total price
    Given user is on the home page
    Then navigate to shop page
    When user adds the following products to the cart
      | Product         | Quantity  |
      | Stuffed Frog    | 2         |
      | Fluffy Bunny    | 5         |
      | Valentine Bear  | 3         |
    Then navigate to cart page
    Then subtotals for all the products added should be calculated correctly
    And total should be equal to the sum of subtotals
