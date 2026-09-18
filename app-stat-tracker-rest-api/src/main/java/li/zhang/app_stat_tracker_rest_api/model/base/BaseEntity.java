package li.zhang.app_stat_tracker_rest_api.model.base;

import java.io.Serializable;

public interface BaseEntity extends Serializable {

    Long getId();

    void setId(final Long id);
}