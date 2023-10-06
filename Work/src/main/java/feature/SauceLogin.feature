Feature: Login page Automation of Saucedemo app
  Scenario Outline: check login is successful with valid cards
    Given User is on login page
  	When User enters valid "<username>" and "<password>"
    And Clicks on Login Button
    Then User in navigated to Home page
    And Close the browser

 Examples:
 | username | password |
 | standard_user | secret_sauce |
 | locked_out_user | secret_sauce |
 | problem_user | secret_sauce |
 | performance_glitch_user | secret_sauce |  
 
 Scenario: check add to cart
 Given User is on login page
  	When User enters valid "<username>" and "<password>"
    And Clicks on Login Button

 When i click add to cart button
 Then its add to cart