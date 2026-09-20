package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import java.util.Optional;

public interface TeamDAO extends JpaRepository<Team, Long>, QueryByExampleExecutor<Team> {
    Optional<Team> findTeamById(Long id);
    Optional<Team> findTeamByTeamName(String teamName);
    Optional<Team> findTeamBy(Example<Team> example);
}
