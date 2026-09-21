package li.zhang.app_stat_tracker_rest_api.dao;




import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;

import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TeamDAOTest {

    private final TeamDAO repository;
    @Autowired
    public TeamDAOTest(TeamDAO repository) {
        this.repository = repository;
    }

    @Test
    void saveAndFindById_ShouldReturnProduct() {
        // Arrange (Given)
        Team entity = new Team("rockets");

        // Act (When)
        Team savedEntity = repository.save(entity);
        Optional<Team> foundProduct = repository.findById(savedEntity.getId());

        // Assert (Then)
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getTeamName()).isEqualTo("rockets");

    }

    @Test
    void findByCategory_ShouldReturnMatchingProducts() {
        // Arrange (Given)
        repository.save(new Team("bulls"));
        repository.save(new Team("sharks"));
        repository.save(new Team("warriors"));

        // Act (When)
        List<Team> teamList = repository.findAll();

        // Assert (Then)
        assertThat(teamList).hasSize(3);

    }
}

