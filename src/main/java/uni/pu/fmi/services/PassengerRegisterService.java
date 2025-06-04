package uni.pu.fmi.services;

import org.apache.commons.validator.routines.EmailValidator;
import uni.pu.fmi.models.Passenger;
import uni.pu.fmi.repos.PassengerRepo;

public class PassengerRegisterService {
    public String register(String username, String email, String password, String confirmPassword) {
        if (username == null || username.length() < 3) return "Username too short";

        if (!EmailValidator.getInstance().isValid(email)) return "Invalid email";

        if (!password.equals(confirmPassword)) return "Passwords do not match";

        if (PassengerRepo.getPassengers().stream().anyMatch(p -> p.getUsername().equals(username)))
            return "Username taken";

        PassengerRepo.getPassengers().add(new Passenger(username, password, email, "passenger"));
        return "Registration successful";
    }
}
