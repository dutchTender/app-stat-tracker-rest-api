package li.zhang.app_stat_tracker_rest_api.services;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
@Service
public class PlayerService implements BaseService<Player> {


    private final PlayerDAO playerDAO;
    private static final Logger logger = Logger.getLogger(PlayerService.class.getName());


    public PlayerService(PlayerDAO playerDAO) {
        this.playerDAO = playerDAO;
    }

    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public Player find(Long id) {
        return this.playerDAO.findPlayerById(id).isPresent() ? this.playerDAO.findPlayerById(id).get() : null;
    }

    @Override
    public Player findByExample(Example<Player> example) {
       return this.playerDAO.findPlayerBy(example).isPresent() ? this.playerDAO.findPlayerBy(example).get() : null;
    }

    @Override
    public List<Player> findAll() {
        return this.playerDAO.findAll();
    }

    @Override
    public List<Player> findAllByExample(Example<Player> example) {
        return this.playerDAO.findAll(example);
    }

    @Override
    public List<Player> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        return this.playerDAO.findAll(Sort.by(sortBy, sortOrder));
    }

    @Override
    public Player create(Player entity) {
        return this.playerDAO.save(entity);
    }

    @Override
    public Player update(Player entity) {
        return this.playerDAO.save(entity);
    }

    @Override
    public void delete(Player entity) {
         this.playerDAO.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        this.playerDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        this.playerDAO.deleteAll();
    }

    @Override
    public long count() {
        return this.playerDAO.count();
    }
}
