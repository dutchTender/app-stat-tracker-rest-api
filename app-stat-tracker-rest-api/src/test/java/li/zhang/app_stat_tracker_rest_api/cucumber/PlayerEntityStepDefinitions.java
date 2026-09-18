package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerEntityStepDefinitions {

    private static final Logger log = LoggerFactory.getLogger(PlayerEntityStepDefinitions.class);
    @Autowired
    private PlayerDAO playerRepository;

    @Given("the database is empty")
    public void theDatabaseIsEmpty() {
        log.info("###################################################");
        playerRepository.deleteAll();
    }

    @When("a user saves a new player named {string}")
    public void aUserSavesANewCustomerNamed(String name) {

        log.info("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        playerRepository.save(new Player(name));
    }

    @Then("a player named {string} should exist in the database")
    public void aCustomerNamedShouldExistInTheDatabase(String name) {
        Optional<Player> customer = playerRepository.findPlayerByUserName(name);
        assertTrue(customer.isPresent(), "Customer should be found in the database");
        log.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        log.info("cucumber tests completed");
    }
}
