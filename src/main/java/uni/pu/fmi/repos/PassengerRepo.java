package uni.pu.fmi.repos;

import uni.pu.fmi.models.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerRepo {
    private static List<Passenger> passengers = new ArrayList<>();

    static {
        passengers.add(new Passenger("ivan", "pass123", "ivan@test.com","passenger"));
    }

    public static List<Passenger> getPassengers() {
        return passengers;
    }
}