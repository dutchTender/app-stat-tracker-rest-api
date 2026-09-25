package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;
import java.util.Optional;

public interface TeamDAO extends JpaRepository<Team, Long>, QueryByExampleExecutor<Team> {
    Optional<TeamDTO> findTeamById(Long id);
    Optional<TeamDTO> findTeamByTeamName(String teamName);
    Optional<TeamDTO> findTeamBy(Example<Team> example);

    List<TeamDTO> findAllBy();
    List<TeamDTO> findAllBy(Example<Team> example);
    Page<TeamDTO> findAllBy(Pageable pageable);
}
