package li.zhang.app_stat_tracker_rest_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractAPIResponse;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestMetaData;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestResponse;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.TeamViewTeamDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.TeamMapper;
import li.zhang.app_stat_tracker_rest_api.services.core.TeamService;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestParams;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = RestParams.TEAM_ENTITY_PATH)
@CrossOrigin(origins = RestParams.API_CLIENT_URL)
public class TeamController extends AbstractController<Team> {

    private final TeamService service;
    private final TeamMapper mapper;
    private final AbstractAPIResponse<List<TeamViewTeamDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<TeamViewTeamDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public TeamController(TeamService service, TeamMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @Override
    protected BaseService<Team> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<AbstractRestResponse<List<TeamViewTeamDTO>>> findAllPlayersPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                                        @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                                        @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                                        @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<Team> teamResultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players : "+teamResultPage.getTotalPages()*teamResultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(mapper.toDTOList(teamResultPage.getContent()) , metaData, RestResponseMessage.TEAMS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<TeamViewTeamDTO>>> findAllPlayers(final HttpServletRequest request) {
        List<Team> teamsResultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: find all TEAM - count : "+teamsResultList.size());
        return apiResponseCollection.createAPIResponse(mapper.toDTOList(teamsResultList) , metaData, RestResponseMessage.TEAMS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<TeamViewTeamDTO>> findOnePlayer(@PathVariable("id") final Long id) {
        Team teamResult = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: find one TEAM - count : 1 ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(teamResult) , metaData, RestResponseMessage.TEAM_GET_SUCCESS,RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<TeamViewTeamDTO>> createPlayer(@RequestBody @Valid final TeamViewTeamDTO dto) {
        Team teamResult = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: create TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(teamResult) , metaData, RestResponseMessage.TEAM_CREATE_SUCCESS,String.valueOf(HttpStatus.CREATED));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<TeamViewTeamDTO>> updatePlayer(@PathVariable("id") final Long id, @RequestBody @Valid TeamViewTeamDTO dto) {
        Team teamResult = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: update TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(teamResult) , metaData, RestResponseMessage.TEAM_UPDATE_SUCCESS, String.valueOf(HttpStatus.OK));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<TeamViewTeamDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_BASE_URL+RestParams.TEAM_ENTITY_PATH, "params: delete TEAM - count : 1  ");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.TEAM_DELETE_SUCCESS, String.valueOf(HttpStatus.NO_CONTENT));
    }

}
