Feature: Passenger login

  Scenario: Successful login
    Given the passenger is on the login page
    When the passenger enters username "ivan"
    And the passenger enters password "pass123"
    And submits the login form
    Then a login message "Login successful" should be shown

  Scenario: Missing password
    Given the passenger is on the login page
    When the passenger enters username "ivan"
    And the passenger enters password ""
    And submits the login form
    Then a login message "Password required" should be shown

  Scenario: Login fails due to non-existing user
    Given the passenger is on the login page
    When the passenger enters username "ghost"
    And the passenger enters password "invisible"
    And submits the login form
    Then a login message "Invalid credentials" should be shown

  Scenario: Login fails due to empty username
    Given the passenger is on the login page
    When the passenger enters username ""
    And the passenger enters password "somepass"
    And submits the login form
    Then a login message "Username required" should be shown

  Scenario: Login fails due to empty password
    Given the passenger is on the login page
    When the passenger enters username "ivan"
    And the passenger enters password ""
    And submits the login form
    Then a login message "Password required" should be shown
