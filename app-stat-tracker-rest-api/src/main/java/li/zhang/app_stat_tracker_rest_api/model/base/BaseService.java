package li.zhang.app_stat_tracker_rest_api.model.base;

import java.util.logging.Logger;

public interface BaseService<T extends BaseEntity, K> extends BaseOperations<T,K> {

    Logger getLogger();

}
