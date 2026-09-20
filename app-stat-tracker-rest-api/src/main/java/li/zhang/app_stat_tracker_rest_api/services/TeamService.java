package li.zhang.app_stat_tracker_rest_api.services;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import li.zhang.app_stat_tracker_rest_api.persistence.dao.TeamDAO;
import li.zhang.app_stat_tracker_rest_api.persistence.entity.Team;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class TeamService implements BaseService<Team> {

    private final TeamDAO teamRepository;
    private static final Logger logger = Logger.getLogger(TeamService.class.getName());

    public TeamService(TeamDAO teamRepository) {
        this.teamRepository = teamRepository;
    }
    @Override
    public Logger getLogger() {
        return logger;
    }

    @Override
    public Team find(Long id) {
        return teamRepository.findTeamById(id).isPresent() ? teamRepository.findTeamById(id).get() : null;
    }

    @Override
    public Team findByExample(Example<Team> example) {
        return  teamRepository.findTeamBy(example).isPresent() ? teamRepository.findTeamBy(example).get() : null;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public List<Team> findAllByExample(Example<Team> example) {
        return teamRepository.findAll(example);
    }

    @Override
    public Page<Team> findAllPaginatedAndSorted(int page, int size, String sortBy, String sortOrder) {
        Sort.Direction direction = Sort.Direction.fromString(sortOrder);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        this.getLogger().log(Level.INFO, "findAllPaginatedAndSorted() params : - {}", pageable);
        return teamRepository.findAll(pageable);
    }

    @Override
    public Team create(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public Team update(Team entity) {
        return teamRepository.save(entity);
    }

    @Override
    public void delete(Team entity) {
        teamRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
            teamRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
            teamRepository.deleteAll();
    }

    @Override
    public long count() {
        return teamRepository.count();
    }
}
