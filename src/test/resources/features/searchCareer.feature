@interview
Feature:
  As a user I can able to search a job from General Motor's Career page, and apply for it after signing in.

  Scenario: Searching job and applying

    Given user on the GM homepage
    And user clicks Careers Tab
    When user input job title or id
    And select the first position
    And click apply now button
    And user sign in to apply
    Then verify user applied successfully
