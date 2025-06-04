package uni.pu.fmi;

import io.cucumber.java.en.*;
import uni.pu.fmi.services.PassengerLoginService;

import static org.junit.Assert.assertEquals;

public class PassengerLoginSteps {
    private String username;
    private String password;
    private String message;
    private PassengerLoginService loginService = new PassengerLoginService();

    @Given("the passenger is on the login page")
    public void onLoginPage() {}

    @When("the passenger enters username {string}")
    public void enterUsername(String username) {
        this.username = username;
    }

    @And("the passenger enters password {string}")
    public void enterPassword(String password) {
        this.password = password;
    }

    @And("submits the login form")
    public void submitLogin() {
        message = loginService.login(username, password);
    }

    @Then("a login message {string} should be shown")
    public void checkLoginMessage(String expected) {
        assertEquals(expected, message);
    }
}