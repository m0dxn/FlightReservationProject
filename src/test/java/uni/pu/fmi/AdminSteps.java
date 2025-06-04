package uni.pu.fmi;

import io.cucumber.java.en.*;
import uni.pu.fmi.models.Flight;
import uni.pu.fmi.models.Passenger;
import uni.pu.fmi.repos.FlightsRepo;
import uni.pu.fmi.services.AdminService;

import static org.junit.Assert.*;

public class AdminSteps {

    private Passenger user;
    private String message;
    private final AdminService adminService = new AdminService();

    @Given("a user with role {string} and name {string}")
    public void a_user_with_role_and_name(String role, String username) {
        user = new Passenger(username, "pass123", username + "@test.com", role);
    }

    @When("the administrator adds a flight with number {string}, from {string} to {string}")
    public void the_administrator_adds_flight(String flightNumber, String from, String to) {
        message = adminService.addFlight(user, flightNumber, from, to);
    }

    @And("a flight with number {string} exists from {string} to {string}")
    public void aFlightExists(String flightNumber, String from, String to) {
        new FlightsRepo().addFlight(new Flight(flightNumber, from, to));
    }

    @When("the administrator deletes flight {string}")
    public void deleteFlight(String flightNumber) {
        message = adminService.deleteFlight(user, flightNumber);
    }

    @Then("a message {string} should be shown")
    public void a_message_should_be_shown(String expected) {
        assertEquals(expected, message);
    }
}
