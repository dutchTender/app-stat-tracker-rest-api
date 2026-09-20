package li.zhang.app_stat_tracker_rest_api.services.util;

import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.stereotype.Service;

@Service
public class SeedService {

    private final PlayerDAO playerDAO;
    public SeedService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
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
        player2.setUserName("black]lighting");
        player2.setEmail("lzhang4333@gmailo.com");
        player2.setFirstName("mike");
        player2.setLastName("johnson");
        player2.setSex("male");
        player2.setPhone("571-555-7777");

        this.playerDAO.saveAndFlush(player2);

        Player player3 = new Player();
        player3.setUserName("whilethunder");
        player3.setEmail("xxxx@gmailo.com");
        player3.setFirstName("nick");
        player3.setLastName("price");
        player3.setSex("male");
        player3.setPhone("222-555-7777");

        this.playerDAO.saveAndFlush(player3);
    }
}
