package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Optional;

public interface GameDAO extends JpaRepository<Game, Long>, QueryByExampleExecutor<Game> {
    Optional<Game> findGameById(Long id);
    Optional<Game> findGameByGameTime(String name);
    Optional<Game> findGameBy(Example<Game> example);
}
