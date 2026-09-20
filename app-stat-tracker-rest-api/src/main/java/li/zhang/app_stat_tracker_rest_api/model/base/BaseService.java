package li.zhang.app_stat_tracker_rest_api.model.base;

import java.util.logging.Logger;

public interface BaseService <T extends BaseEntity>  extends BaseOperations<T> {

    Logger getLogger();

}
