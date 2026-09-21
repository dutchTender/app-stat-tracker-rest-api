package li.zhang.app_stat_tracker_rest_api.services.util;

import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class SeedService {

    private final PlayerDAO playerDAO;
    private final TeamDAO teamDAO;
    public SeedService(PlayerDAO playerDAO,  TeamDAO teamDAO) {

        this.playerDAO = playerDAO;
        this.teamDAO = teamDAO;
    }


    public void seedDB(){
        Player player1 = new Player();
        player1.setUserName("dutchTender");
        player1.setEmail("lzhang421@gmailo.com");
        player1.setFirstName("li");
        player1.setLastName("zhang");
        player1.setSex("male");
        player1.setPhone("571-839-7777");

        this.playerDAO.saveAndFlush(player1);

        Player player2 = new Player();
        player2.setUserName("black-lighting");
        player2.setEmail("lzhang4333@gmailo.com");
        player2.setFirstName("mike");
        player2.setLastName("johnson");
        player2.setSex("male");
        player2.setPhone("571-555-7777");

        this.playerDAO.saveAndFlush(player2);

        Player player3 = new Player();
        player3.setUserName("white-thunder");
        player3.setEmail("xxxx@gmailo.com");
        player3.setFirstName("nick");
        player3.setLastName("price");
        player3.setSex("male");
        player3.setPhone("222-555-7777");

        this.playerDAO.saveAndFlush(player3);



        Team team1 = new Team("Team-Thunder");
        team1.setTeamCoachName("Dutch Tender");
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        team1.addPlayer(player3);
        this.teamDAO.saveAndFlush(team1);
        /*
         player1.setTeam(team1);
        player2.setTeam(team1);
        player3.setTeam(team1);
        this.playerDAO.saveAndFlush(player1);
        this.playerDAO.saveAndFlush(player2);
        this.playerDAO.saveAndFlush(player3);

         */

    }
}
