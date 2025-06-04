package uni.pu.fmi.services;

import uni.pu.fmi.models.Flight;
import uni.pu.fmi.repos.FlightsRepo;
import uni.pu.fmi.models.Passenger;

public class AdminService {

    public String addFlight(Passenger user, String flightNumber, String from, String to) {
        if (user == null || !"admin".equals(user.getRole())) {
            return "You do not have permission for this operation";
        }
        if (flightNumber.isBlank() || from.isBlank() || to.isBlank()) {
            return "Invalid flight data";
        }

        Flight flight = new Flight(flightNumber, from, to);
        new FlightsRepo().addFlight(flight);
        return "Flight successfully added";
    }

    public String deleteFlight(Passenger user, String flightNumber) {
        if (user == null || !"admin".equals(user.getRole())) {
            return "You do not have permission to delete flights";
        }

        boolean removed = new FlightsRepo().removeFlightByNumber(flightNumber);
        return removed ? "Flight successfully deleted" : "Flight not found";
    }

}
