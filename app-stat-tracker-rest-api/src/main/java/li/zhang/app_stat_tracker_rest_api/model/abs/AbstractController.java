package li.zhang.app_stat_tracker_rest_api.model.abs;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;


public abstract class AbstractController<T extends BaseEntity> extends  AbstractReadController<T> {


    protected final T createEntity(final T entity) {

        return getService().create(entity);
    }

    protected final T updateInternal(final T entity) {

        return getService().update(entity);
    }

    protected final void deleteById(final T id) {

        getService().delete(id);
    }
}
