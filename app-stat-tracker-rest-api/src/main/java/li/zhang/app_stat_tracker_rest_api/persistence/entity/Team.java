package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;

import java.util.Set;


@Entity
@Table(name = "Team")
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

    @OneToMany(mappedBy = "teams")
    public Set<Player> players;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCoachName() {
        return teamCoachName;
    }

    public void setTeamCoachName(String teamCoachName) {
        this.teamCoachName = teamCoachName;
    }

    public String getTeamSponsors() {
        return teamSponsors;
    }

    public void setTeamSponsors(String teamSponsors) {
        this.teamSponsors = teamSponsors;
    }
}

