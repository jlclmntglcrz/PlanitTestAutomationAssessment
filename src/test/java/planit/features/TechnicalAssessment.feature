Feature: Planit- Technical Assessment


  @TestTechnicalAssessment
  Scenario: Contact Page Error Messages
    Given I navigate to "Jupiter Toys" home page
    And I go to "contact" page
    And I click "submit" on "Contact" page
    Then verify that the following is displayed on "Contact" page
      | Forename error message |
      | Email error message    |
      | Message error message  |
    And I populate the following fields on "Contact" page
      | Forename | Email               | Message      |
      | John     | john.test@email.com | Test message |
    Then verify that the following is not displayed on "Contact" page
      | Forename error message |
      | Email error message    |
      | Message error message  |


  @TestTechnicalAssessment
  Scenario Outline: Submit contact details successfully
    Given I navigate to "Jupiter Toys" home page
    And I go to "contact" page
    And I populate the following fields on "Contact" page
      | Forename   | Email   | Message   |
      | <Forename> | <Email> | <Message> |
    And I click "submit" on "Contact" page
    Then validate successful submission message
    Examples:
      | Forename | Email                | Message                          |
      | John     | johntest@email.com   | Toys are great!                  |
      | Kai      | kaitest@email.com    | Good stuffs here!                |
      | Mary     | marytest@email.com   | Keep it up                       |
      | Ann      | anntest@email.com    | Will buy again                   |
      | Nathan   | nathantest@email.com | Love it, Please have more stocks |


  @TestTechnicalAssessment
  Scenario: Contact Page Error Messages
    Given I navigate to "Jupiter Toys" home page
    And I go to "shop" page
    And I buy the following toys
      | Stuffed Frog | Fluffy Bunny | Valentine Bear |
      | 2            | 5            | 3              |
    And I go to "cart" page
    Then I verify the subtotal for each product
      | Stuffed Frog | Fluffy Bunny | Valentine Bear |
      | $21.98       | $49.95       | $44.97         |
    Then I verify the price for each product
      | Stuffed Frog | Fluffy Bunny | Valentine Bear |
      | $10.99       | $9.99        | $14.99         |
    Then I verify that total = "116.9"

