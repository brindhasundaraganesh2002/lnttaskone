Feature:Plum Goodness Website Features
  Scenario: Highlight and Print Logo Properties
    Given I am on the Plum Goodness website
    When I highlight the logo
    And I print logo CSS properties
    Then I should see the header content
 @login
	 Scenario: User Login with valid username and password from Excel
    Given I am on the Plum Goodness website
   	When I navigate to the login page
   When I enter test username and password from Excel
    And I click the test login button
    Then I should be logged into test

Examples:
 | Sheetname | RowNumber | 
 | Sheet1    |    1      |

	@login_invalid
  Scenario:User Login with invalid username and password 
  	Given I am on the Plum Goodness website
  	When I navigate to the login page
  	When I enter invalid username and password
  	Then It show login fail message
 	@navigation  
 	Scenario: Navigate to Skincare Collection & Plum Bodylovin & Makeup Collection
 			Given I am on the Plum Goodness website
 			Then I navigate to the skincare collection
 			Then I navigate to the Plum Bodylovin page
 			When I should see the makeup collection page
 			Then I should see the dropdown options
 @product_search
 Scenario: Search for a product information
    Given I am on the Plum Goodness website
    When I search for the product "palm"
    And I click on the product
    Then I am scrolling down 
  	Then I am scrolling up    
@Add_TO_Cart
 Scenario: Add a Product to Cart and payment
 		Given I am on the Plum Goodness website
    When I search for the product "palm"
    And I click on the product
    And I add the product to the cart using JavaScript
    And I click on the cart button
    And I click on "View cart"
    Then I should be in the shopping cart page
    
@customer_care
    Scenario: check customer care functionalities
     Given I am on the Plum Goodness website
     When I scroll bottom
     And I click on the contact us
     And I click on the Mail Button
@logout
Scenario: User logout
 	Given I am on the Plum Goodness website
   	When I navigate to the login page
   When I enter test username and password from Excel
    And I click the test login button
    Then I should be logged into test
   	Then I am goto click the logout button
 