package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.QueryByExampleExecutor;


import java.util.Optional;

public interface PlayerDAO extends JpaRepository<Player, Long> , QueryByExampleExecutor<Player> {
    Optional<Player> findPlayerById(Long id);
    Optional<Player> findPlayerByUserName(String name);
    Optional<Player> findPlayerBy(Example<Player> example);

}
