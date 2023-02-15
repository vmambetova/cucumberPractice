@RunPositiveTests
Feature: Register scenario tested

  Background:
    Given I am on the shop homepage
    When I click on My account
    And I select Register in My account menu

  @QESDEMO-2108
  Scenario Outline: Register happy path
    When I fill in all the input fields with valid "<userData>"
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see "Your Account Has Been Created!" message
    And I click continue in the message window
    Then I Get redirected to My account page
    And I see the links
    Examples:
      | userData                                                            |
      | First Name, Last Name, Email, Telephone, Password, Password Confirm |