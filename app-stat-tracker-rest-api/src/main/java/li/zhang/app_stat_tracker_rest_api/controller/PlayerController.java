package li.zhang.app_stat_tracker_rest_api.controller;

import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.services.PlayerService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/players")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController extends AbstractController<Player> {


    private final PlayerService service;

    public PlayerController( PlayerService service ) {
        this.service = service;
    }





    @Override
    protected BaseService<Player> getService() {
        return service;
    }
}
