Scenario: Retrieve product information by product id

Given a product id
When I request information about that id
Then I will receive a product description response

Scenario: Update a products price given a product id

Given a productid related to a price
And a new price
When I request an update to that price
Then I will be able to retrieve a new price for that id
