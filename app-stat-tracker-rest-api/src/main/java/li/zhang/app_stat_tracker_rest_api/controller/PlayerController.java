package li.zhang.app_stat_tracker_rest_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractAPIResponse;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestMetaData;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractRestResponse;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.PlayerMapper;
import li.zhang.app_stat_tracker_rest_api.services.PlayerService;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestParams;
import li.zhang.app_stat_tracker_rest_api.utils.constants.RestResponseMessage;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/players")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController extends AbstractController<Player> {


    private final PlayerService service;
    private final PlayerMapper mapper;
    private final AbstractAPIResponse<List<PlayerDTO>> apiResponseCollection = new AbstractAPIResponse<>();
    private final AbstractAPIResponse<PlayerDTO> apiResponseSingleton = new AbstractAPIResponse<>();

    public PlayerController(PlayerService service, PlayerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<Player> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public
    ResponseEntity<AbstractRestResponse<List<PlayerDTO>>> findAllPlayersPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                                     @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                                     @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                     @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        Page<Player> playersResultPage = this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: sort by - {" +sortBy+" }" + " sort order - { "+sortOrder+" }  page - {"+page+"}  size - {"+size+"} total players : "+playersResultPage.getTotalPages()*playersResultPage.getContent().size());
        return apiResponseCollection.createAPIResponse(mapper.toDTOList(playersResultPage.getContent()) , metaData, RestResponseMessage.USERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @GetMapping()
    public ResponseEntity<AbstractRestResponse<List<PlayerDTO>>> findAllPlayers(final HttpServletRequest request) {
        List<Player> playersResultList = this.service.findAll();
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: find all - no params");
        return apiResponseCollection.createAPIResponse(mapper.toDTOList(playersResultList) , metaData, RestResponseMessage.USERS_GET_SUCCESS, RestParams.API_STATUS_OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> findOnePlayer(@PathVariable("id") final Long id) {
        Player playerResult = service.find(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: find one by id");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(playerResult) , metaData, RestResponseMessage.USER_GET_SUCCESS, RestParams.API_STATUS_OK);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> createPlayer(@RequestBody @Valid final PlayerDTO dto) {
        Player playerResult = service.create(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: create player");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(playerResult) , metaData, RestResponseMessage.USER_CREATE_SUCCESS, RestParams.API_STATUS_OK);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> updatePlayer(@PathVariable("id") final Long id, @RequestBody @Valid PlayerDTO dto) {
        Player playerResult = service.update(mapper.toEntity(dto));
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: update player");
        return apiResponseSingleton.createAPIResponse(mapper.toDTO(playerResult) , metaData, RestResponseMessage.USER_UPDATE_SUCCESS, RestParams.API_STATUS_OK);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<AbstractRestResponse<PlayerDTO>> delete(@PathVariable("id") final Long id) {
        this.service.deleteById(id);
        AbstractRestMetaData metaData = new AbstractRestMetaData(RestParams.API_Base_URL+RestParams.PLAYER_ENTITY_PATH, "params: delete player");
        return apiResponseSingleton.createAPIResponse(null , metaData, RestResponseMessage.USER_DELETE_SUCCESS, RestParams.API_STATUS_OK);
    }

}
