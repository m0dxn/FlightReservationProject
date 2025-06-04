Feature: Flight management by Administrator

  Scenario: Successful flight addition
    Given a user with role "admin" and name "admin1"
    When the administrator adds a flight with number "FL123", from "Sofia" to "London"
    Then a message "Flight successfully added" should be shown

  Scenario: Non-admin user tries to add a flight
    Given a user with role "passenger" and name "ivan"
    When the administrator adds a flight with number "FL999", from "Sofia" to "London"
    Then a message "You do not have permission for this operation" should be shown

  Scenario: Successful deletion of existing flight
    Given a user with role "admin" and name "admin1"
    And a flight with number "FL321" exists from "Sofia" to "London"
    When the administrator deletes flight "FL321"
    Then a message "Flight successfully deleted" should be shown

  Scenario: Deleting non-existent flight
    Given a user with role "admin" and name "admin1"
    When the administrator deletes flight "NONEXIST"
    Then a message "Flight not found" should be shown

  Scenario: Non-admin tries to delete flight
    Given a user with role "passenger" and name "ivan"
    When the administrator deletes flight "FL321"
    Then a message "You do not have permission to delete flights" should be shown
