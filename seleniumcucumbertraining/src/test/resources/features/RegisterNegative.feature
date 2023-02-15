@RunPositiveTests
Feature: Register scenario tested

  Background:
    Given I am on the shop homepage
    When I click on My account
    And I select Register in My account menu

  @QESDEMO-2112
  Scenario Outline: Register with one field empty
    When I leave one field empty "<userDataForOneFieldEmpty>"
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see error messages for empty fields "<errorMessages>"
    Examples:
      | userDataForOneFieldEmpty | errorMessages                                   |
      | First Name               | First Name must be between 1 and 32 characters! |
      | Last Name                | Last Name must be between 1 and 32 characters!  |
      | Email                    | E-Mail Address does not appear to be valid!     |
      | Telephone                | Telephone must be between 3 and 32 characters!  |
      | Password                 | Password must be between 4 and 20 characters!   |
      | Password Confirm         | Password confirmation does not match password!  |

  @QESDEMO-2112-1
  Scenario Outline: Register with all fields empty
    When I leave all input fields empty
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see error messages for all empty fields
    And I fill in all the input fields with valid "<userData>"
    And I untick the privacy policy warning message
    And I press continue on the registration page
    Then I see privacy policy warning message
    Examples:
      | userData                                                            |
      | First Name, Last Name, Email, Telephone, Password, Password Confirm |

  Scenario: Register with password and password confirm not matching
    When I fill the input fields with password and password confirm not matching
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see warning message

#    Is there a way to avoid hardcoded values using faker?
  Scenario: Register with credentials of existing user
    When I fill in all the input fields
      | First Name       | Joey                    |
      | Last Name        | Tribbiani               |
      | Email            | joeytribbiani@gmail.com |
      | Telephone        | 123456789               |
      | Password         | 1234                    |
      | Password Confirm | 1234                    |
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I can see email already registered error message

#    Bug QESDEMO-2137
  Scenario: Register with first name too long
    When I fill in all the input fields with fields values too long
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see error messages for input too long
    And I fill in all the input fields with telephone and password fields values too short
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see error messages for input too short

  Scenario Outline: Register with incorrect email format
    When I fill the input fields except email "<field>" with invalid data "<value>"
    And I tick agree to privacy policy
    And I press continue on the registration page
    Then I see "<warning>" message about incorrect email format
    Examples:
      | field | value         | warning                                                                       |
      | Email | rachel.green  | Please include an '@' in the email address. 'rachel.green' is missing an '@'. |
      | Email | we@.gmail.com | '.' is used at a wrong position in '.gmail.com'.                              |
      | Email | @gmail.com    | Please enter a part followed by '@'. '@gmail.com' is incomplete.              |
      | email | email@        | Please enter a part following '@'. 'email@' is incomplete.                    |