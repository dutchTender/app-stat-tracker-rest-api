package li.zhang.app_stat_tracker_rest_api.controller;

import li.zhang.app_stat_tracker_rest_api.model.abs.AbstractController;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.model.constants.QueryConstants;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import li.zhang.app_stat_tracker_rest_api.services.PlayerService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


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


    public Page<Player> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder) {
        return this.service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
    }
    @GetMapping(params = { QueryConstants.PAGE, QueryConstants.SIZE, QueryConstants.SORT_BY })
    public ResponseEntity<Page<Player>> findAllPaginatedAndSortedDTO(@RequestParam(value = QueryConstants.PAGE) final int page, @RequestParam(value = QueryConstants.SIZE) final int size, @RequestParam(value = QueryConstants.SORT_BY) final String sortBy,
                                                                                            @RequestParam(value = QueryConstants.SORT_ORDER) final String sortOrder) {
        return ResponseEntity.of(Optional.ofNullable(findAllPaginatedAndSorted(page, size, sortBy, sortOrder)));

    }







}
