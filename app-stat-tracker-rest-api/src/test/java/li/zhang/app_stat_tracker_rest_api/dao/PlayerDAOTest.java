package li.zhang.app_stat_tracker_rest_api.dao;


import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlayerDAOTest {

    private final PlayerDAO  repository;
    @Autowired
    public PlayerDAOTest(PlayerDAO repository) {
        this.repository = repository;
    }

    @Test
    void saveAndFindById_ShouldReturnProduct() {
        // Arrange (Given)
        Player entity = new Player("lizhang");

        // Act (When)
        Player savedEntity = repository.save(entity);
        Optional<Player> foundProduct = repository.findById(savedEntity.getId());

        // Assert (Then)
        assertThat(foundProduct).isPresent();
        assertThat(foundProduct.get().getUserName()).isEqualTo("lizhang");

    }

    @Test
    void findByCategory_ShouldReturnMatchingProducts() {
        // Arrange (Given)
        repository.save(new Player("LL2345654"));
        repository.save(new Player("mentor4578"));
        repository.save(new Player("JayKilla567"));

        // Act (When)
        List<Player> playerList = repository.findAll();

        // Assert (Then)
        assertThat(playerList).hasSize(3);

    }
}
