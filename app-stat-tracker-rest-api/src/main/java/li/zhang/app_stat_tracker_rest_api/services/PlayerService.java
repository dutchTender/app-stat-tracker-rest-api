package li.zhang.app_stat_tracker_rest_api.services;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.PlayerDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
@Service
public class PlayerService implements BaseService<Player> {


    private final PlayerDAO playerDAO;


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
    public Page<Player> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return this.playerDAO.findAll(pageable);
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
