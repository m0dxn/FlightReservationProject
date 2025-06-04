package uni.pu.fmi.services;

import uni.pu.fmi.models.Passenger;
import uni.pu.fmi.repos.PassengerRepo;

public class PassengerLoginService {
    public String login(String username, String password) {
        if (username == null || username.isBlank()) return "Username required";
        if (password == null || password.isBlank()) return "Password required";

        return PassengerRepo.getPassengers().stream()
                .anyMatch(p -> p.getUsername().equals(username) && p.getPassword().equals(password))
                ? "Login successful" : "Invalid credentials";
    }
}