package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeamEntityStepDefinitions {
    private static final Logger log = LoggerFactory.getLogger(PlayerEntityStepDefinitions.class);
    private final TeamDAO repository;
    public TeamEntityStepDefinitions(TeamDAO repository) {
        this.repository = repository;
    }
    @Given("the team database is empty")
    public void theDatabaseIsEmpty() {
        repository.deleteAll();
    }

    @When("a user saves a new team named {string}")
    public void aUserSavesANewCustomerNamed(String name) {
        repository.save(new Team(name));
    }

    @Then("a team named {string} should exist in the database")
    public void aCustomerNamedShouldExistInTheDatabase(String name) {
        Optional<Team> team = repository.findTeamByTeamName(name);
        assertTrue(team.isPresent(), "Customer should be found in the database");
        log.info("cucumber tests completed");
    }
}
