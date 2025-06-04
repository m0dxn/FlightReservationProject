Feature: Flight reservation

  Scenario: Make a successful reservation
    Given a passenger "petar" with email "petar@test.com"
    When they choose flight "FL123" from "Sofia" to "Paris"
    And they confirm the reservation
    Then the reservation should be created successfully

  Scenario: Unsuccessful reservation with missing flight info
    Given a passenger "nikolay" with email "niko@test.com"
    When they choose flight "" from "Sofia" to ""
    And they confirm the reservation
    Then the reservation should not be created and a message "Invalid flight information" should be shown
