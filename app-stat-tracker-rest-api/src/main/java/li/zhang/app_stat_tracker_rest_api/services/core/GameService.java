package li.zhang.app_stat_tracker_rest_api.services.core;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.GameDAO;

import li.zhang.app_stat_tracker_rest_api.persistence.dto.GameDTO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Game;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class GameService implements BaseService<Game, GameDTO> {

    private final GameDAO gameDAO;

    private static final Logger logger = Logger.getLogger(GameService.class.getName());

    public GameService(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public GameDTO find(Long id) {
        return this.gameDAO.findGameById(id).orElse(null);
    }

    @Override
    public Game findByExample(Example<Game> example) {
        return null;
    }

    @Override
    public List<GameDTO> findAll() {
        return List.of();
    }

    @Override
    public List<Game> findAllByExample(Example<Game> example) {
        return List.of();
    }

    @Override
    public Page<GameDTO> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return null;
    }

    @Override
    public Game create(Game entity) {
       return this.gameDAO.save(entity);
    }

    @Override
    public Game update(Game entity) {

        return this.gameDAO.save(entity);
    }

    @Override
    public void delete(Game entity) {
            this.gameDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
            this.gameDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
            this.gameDAO.deleteAll();
    }

    @Override
    public long count() {
        return 0;
    }
}
