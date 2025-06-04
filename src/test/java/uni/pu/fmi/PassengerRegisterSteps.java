package uni.pu.fmi;

import io.cucumber.java.en.*;
import uni.pu.fmi.services.PassengerRegisterService;

import static org.junit.Assert.assertEquals;

public class PassengerRegisterSteps {

    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String message;
    private PassengerRegisterService registerService = new PassengerRegisterService();

    @Given("the passenger is on the registration page")
    public void onRegisterPage() {
    }

    @When("the passenger fills registration username {string}")
    public void enterUsername(String username) {
        this.username = username;
    }

    @And("the passenger fills registration email {string}")
    public void enterEmail(String email) {
        this.email = email;
    }

    @And("the passenger fills registration password {string}")
    public void enterPassword(String password) {
        this.password = password;
    }

    @And("the passenger confirms password {string}")
    public void enterConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @And("submits the registration form")
    public void submitRegisterForm() {
        message = registerService.register(username, email, password, confirmPassword);
    }

    @Then("a registration message {string} should be shown")
    public void checkRegistrationMessage(String expected) {
        assertEquals(expected, message);
    }
}