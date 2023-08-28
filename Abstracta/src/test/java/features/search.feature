Feature: Search a product validate and remove

  @SearchProductScenario
Scenario: Search product
  Given start the web
  When search product "Iphone"
  And validate that the search works
  But select the product
  But validate that the button Add to Cart exist
  But send the product to the basket
  And validate that the product was add to the card
  But select cart
  And Validate that the product "iPhone" is in the cart
  And send to view cart
  But validate the product "iPhone" in the cart page
  And delete product of cart page
  Then validate that the shopping cart is empty






