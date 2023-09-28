Feature:Contact Page Validation and Submission

  Background:
    Given user is on home page
    Then navigate to contact page

  Scenario Outline: Submitting the Contact Form with Errors
    And click on Submit button
    Then error messages should be displayed

    And populate the mandatory fields "<Forename>","<Email>","<Message>"
    Then errors should be gone
    Examples:
    | Forename | Email          | Message   |
    | Sam      | sam@277.com    | Test      |

  Scenario Outline: Submitting the Contact Form Successfully
    And populate mandatory fields "<Forename>","<Email>","<Message>"
    And click on Submit button
    Then successful submission message should be displayed
    Examples:
      | Forename | Email               | Message         |
      | Riya     | riya@example.com    | Test Message    |
      | abc      | abc@example.com     | Test Message123 |
      | test     | test@example.com    | Test Message1   |
      | test1    | test1@example.com   | Test Message2   |
      | test2    | test2@example.com   | Test Message @3 |







