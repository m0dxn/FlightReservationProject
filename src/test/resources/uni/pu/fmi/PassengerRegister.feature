Feature: Passenger registration

  Scenario: Successful registration
    Given the passenger is on the registration page
    When the passenger fills registration username "maria"
    And the passenger fills registration email "maria@test.com"
    And the passenger fills registration password "123456"
    And the passenger confirms password "123456"
    And submits the registration form
    Then a registration message "Registration successful" should be shown

  Scenario: Passwords do not match
    Given the passenger is on the registration page
    When the passenger fills registration username "maria"
    And the passenger fills registration email "maria@test.com"
    And the passenger fills registration password "123456"
    And the passenger confirms password "wrongpass"
    And submits the registration form
    Then a registration message "Passwords do not match" should be shown

  Scenario: Registration fails due to taken username
    Given the passenger is on the registration page
    When the passenger fills registration username "ivan"
    And the passenger fills registration email "ivan2@test.com"
    And the passenger fills registration password "123456"
    And the passenger confirms password "123456"
    And submits the registration form
    Then a registration message "Username taken" should be shown

  Scenario: Registration fails due to invalid email
    Given the passenger is on the registration page
    When the passenger fills registration username "nina"
    And the passenger fills registration email "not-an-email"
    And the passenger fills registration password "123456"
    And the passenger confirms password "123456"
    And submits the registration form
    Then a registration message "Invalid email" should be shown

  Scenario: Registration fails due to password mismatch
    Given the passenger is on the registration page
    When the passenger fills registration username "lora"
    And the passenger fills registration email "lora@test.com"
    And the passenger fills registration password "pass1"
    And the passenger confirms password "pass2"
    And submits the registration form
    Then a registration message "Passwords do not match" should be shown


