package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface GameDAO extends JpaRepository<Game, Long>, QueryByExampleExecutor<Game> {
    Optional<GameDTO> findGameById(Long id);
    Optional<GameDTO> findGameByGameTime(String name);
    Optional<Game> findGameBy(Example<Game> example);
    List<GameDTO> findAllBy();
    List<Game> findAllBy(Example<Game> example);
    Page<GameDTO> findAllBy(Pageable pageable);
}
