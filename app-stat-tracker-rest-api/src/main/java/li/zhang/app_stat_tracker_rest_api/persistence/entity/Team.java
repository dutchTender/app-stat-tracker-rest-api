package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "Team")
@Getter
@Setter
public class Team implements BaseEntity {
    @Id
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String teamName;

    public String teamCoachName;

    public String teamSponsors;

    @OneToMany(mappedBy = "homeTeam")
    private Set<Game> homeGames;


    @OneToMany(mappedBy = "awayTeam")
    private Set<Game> awayGames;


    @OneToMany(mappedBy = "team")
    private Set<Player> players;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(id, team.id) && Objects.equals(teamName, team.teamName) && Objects.equals(teamCoachName, team.teamCoachName) && Objects.equals(teamSponsors, team.teamSponsors) && Objects.equals(homeGames, team.homeGames) && Objects.equals(awayGames, team.awayGames) && Objects.equals(players, team.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName, teamCoachName, teamSponsors, homeGames, awayGames, players);
    }
}

