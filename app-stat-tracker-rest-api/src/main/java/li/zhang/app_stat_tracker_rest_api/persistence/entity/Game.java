package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.*;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;




@Entity
@Table(name = "Game")
public class Game implements BaseEntity {

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
    public String gameTime;

    public String gameLocation;


    @Column( name = "home_team_id")
    public Long homeTeam;


    @Column( name = "away_team_id")
    public Long awayTeam;

    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(String gameLocation) {
        this.gameLocation = gameLocation;
    }

    public Long getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Long homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Long getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Long awayTeam) {
        this.awayTeam = awayTeam;
    }
}
