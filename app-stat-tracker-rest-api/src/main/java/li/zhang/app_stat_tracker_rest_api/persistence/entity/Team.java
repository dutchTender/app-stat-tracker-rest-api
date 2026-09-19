package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;

import java.util.HashSet;
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

    @OneToMany(
            mappedBy = "homeTeam",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Game> homeGames = new HashSet<>();


    @OneToMany(
            mappedBy = "awayTeam",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Game> awayGames = new HashSet<>();

    public Set<Game> getHomeGames() {
        return homeGames;
    }

    public void setHomeGames(Set<Game> homeGames) {
        this.homeGames = homeGames;
    }

    public Set<Game> getAwayGames() {
        return awayGames;
    }

    public void setAwayGames(Set<Game> awayGames) {
        this.awayGames = awayGames;
    }
}

