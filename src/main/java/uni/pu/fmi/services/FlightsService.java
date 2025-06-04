package uni.pu.fmi.services;

import uni.pu.fmi.models.Flight;
import uni.pu.fmi.repos.FlightsRepo;

import java.util.List;

public class FlightsService {

    public Flight findFlightByNumber(String number) {
        return FlightsRepo.getFlights().stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(number))
                .findFirst()
                .orElse(null);
    }

    public String addFlight(String number, String origin, String destination) {
        if (number.isBlank() || origin.isBlank() || destination.isBlank()) {
            return "All fields are required";
        }
        Flight flight = new Flight(number, origin, destination);
        FlightsRepo.addFlight(flight);
        return "Flight added successfully";
    }
}
