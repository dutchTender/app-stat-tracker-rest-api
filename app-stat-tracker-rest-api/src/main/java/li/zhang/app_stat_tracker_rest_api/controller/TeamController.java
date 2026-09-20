package li.zhang.app_stat_tracker_rest_api.controller;

import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.TeamMapper;
import li.zhang.app_stat_tracker_rest_api.services.TeamService;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestParams;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = RestParams.PLAYER_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class TeamController extends AbstractController<Team> {

    private final TeamService service;
    private final TeamMapper mapper;
    public TeamController(TeamService service, TeamMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @Override
    protected BaseService<Team> getService() {
        return service;
    }



}
