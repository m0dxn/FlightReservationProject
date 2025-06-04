package uni.pu.fmi.repos;

import uni.pu.fmi.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightsRepo {
    private static final List<Flight> flights = new ArrayList<>();

    static {
        flights.add(new Flight("FL123", "Sofia", "Paris"));
        flights.add(new Flight("FL456", "Varna", "London"));
    }

    public static List<Flight> getFlights() {
        return flights;
    }

    public static void addFlight(Flight flight) {
        flights.add(flight);
    }

    public boolean removeFlightByNumber(String flightNumber) {
        return flights.removeIf(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }

}
