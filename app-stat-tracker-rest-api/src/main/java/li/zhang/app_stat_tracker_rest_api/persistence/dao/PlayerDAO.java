package li.zhang.app_stat_tracker_rest_api.persistence.dao;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;


import java.util.List;
import java.util.Optional;

public interface PlayerDAO extends JpaRepository<Player, Long> , QueryByExampleExecutor<Player> {

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO( p.id, p.userName, p.firstName, p.lastName,p.email, p.phone, p.sex, " +
            "  new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "WHERE p.id = :id")
    Optional<PlayerDTO> findPlayerById(@Param("id") Long id);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO( p.id, p.userName, p.firstName, p.lastName,p.email, p.phone, p.sex, " +
            "  new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t " + // Explicit JOIN to fetch team data efficiently
            "WHERE p.userName = :name")
    Optional<PlayerDTO> findPlayerByUserName(@Param("name") String name);

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO( p.id, p.userName, p.firstName, p.lastName,p.email, p.phone, p.sex, " +
            "  new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t ")
    List<PlayerDTO> findAllBy();

    @Query("SELECT new li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO( p.id, p.userName, p.firstName, p.lastName,p.email, p.phone, p.sex, " +
            "  new li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamDTO(t.id, t.teamName,t.teamCoachName, t.teamSponsors)" + ") " +
            "FROM Player p " +
            "left JOIN p.team t ")
    Page<PlayerDTO> findAllBy(Pageable pageable);

    List<Player> findAllPlayerBy(Example<Player> example);
    Optional<Player> findPlayerBy(Example<Player> example);
}
