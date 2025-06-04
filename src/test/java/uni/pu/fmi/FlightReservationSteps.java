package uni.pu.fmi;

import io.cucumber.java.en.*;
import uni.pu.fmi.models.Flight;
import uni.pu.fmi.models.Passenger;
import uni.pu.fmi.models.Reservation;
import uni.pu.fmi.services.FlightsService;

import static org.junit.Assert.*;

public class FlightReservationSteps {

    private Flight flight;
    private Passenger passenger;
    private Reservation reservation;
    private String reservationErrorMessage;
    private FlightsService flightService = new FlightsService();

    @Given("a passenger {string} with email {string}")
    public void createPassenger(String username, String email) {
        passenger = new Passenger(username, "pass123", email, "passenger");
    }

    @When("they choose flight {string} from {string} to {string}")
    public void chooseFlight(String flightNumber, String origin, String destination) {
        flightService.addFlight(flightNumber, origin, destination);
        flight = flightService.findFlightByNumber(flightNumber);
    }

    @And("they confirm the reservation")
    public void confirmReservation() {
        if (flight == null ||
                flight.getFlightNumber().isBlank() ||
                flight.getOrigin().isBlank() ||
                flight.getDestination().isBlank()) {
            reservationErrorMessage = "Invalid flight information";
            reservation = null;
        } else {
            reservation = new Reservation(passenger, flight);
            reservationErrorMessage = null;
        }
    }

    @Then("the reservation should be created successfully")
    public void successfulReservation() {
        assertNotNull("Reservation should not be null", reservation);
    }

    @Then("the reservation should not be created and a message {string} should be shown")
    public void unsuccessfulReservation(String expectedMessage) {
        assertNull(reservation);
        assertEquals(expectedMessage, reservationErrorMessage);
    }

}