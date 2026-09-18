package li.zhang.app_stat_tracker_rest_api.model.abs;

import jakarta.servlet.http.HttpServletRequest;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;

import li.zhang.app_stat_tracker_rest_api.model.base.BaseService;
import org.springframework.data.domain.Example;

import java.util.List;


public abstract class AbstractReadController<T extends BaseEntity> {


    protected final T findOneEntity(final Long id) {
        return getService().find(id);
    }


    protected final T findOneEntityByExample(Example<T> example) {
        return getService().findByExample(example);
    }

    protected final List<T> findAllEntities(final HttpServletRequest request) {

        return getService().findAll();
    }

    protected final List<T> findAlEntitiesByExample(Example<T> example) {

        return getService().findAllByExample(example);
    }

    protected final long countEntities() {

        return getService().count();
    }

    protected abstract BaseService<T> getService();
}
