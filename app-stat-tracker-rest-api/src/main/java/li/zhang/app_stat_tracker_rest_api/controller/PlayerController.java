package li.zhang.app_stat_tracker_rest_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;
import li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.persistence.mapper.PlayerMapper;
import li.zhang.app_stat_tracker_rest_api.services.PlayerService;
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

    public PlayerController(PlayerService service, PlayerMapper mapper) {

        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected BaseService<Player> getService() {
        return service;
    }

    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<Page<Player>> findAllPlayersPaginatedAndSorted(@RequestParam(value = QueryConstants.PAGE) final int page,
                                                                     @RequestParam(value = QueryConstants.SIZE) final int size,
                                                                     @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                     @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        return ResponseEntity.of(Optional.of(this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder)));
    }

    @GetMapping()
    public ResponseEntity<List<PlayerDTO>>  findAllPlayers(final HttpServletRequest request) {
        return ResponseEntity.of(Optional.ofNullable(mapper.toDTOList(this.service.findAll())));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<PlayerDTO> findOnePlayer(@PathVariable("id") final Long id) {
        return ResponseEntity.of(Optional.ofNullable(mapper.toDTO(service.find(id))));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody @Valid final PlayerDTO dto) {
        return ResponseEntity.of(Optional.ofNullable(mapper.toDTO(this.service.create(mapper.toEntity(dto)))));
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("id") final Long id, @RequestBody @Valid PlayerDTO dto) {
        return ResponseEntity.of(Optional.ofNullable(mapper.toDTO(service.update(mapper.toEntity(dto)))));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final Long id) {
           this.service.deleteById(id);
    }

}
