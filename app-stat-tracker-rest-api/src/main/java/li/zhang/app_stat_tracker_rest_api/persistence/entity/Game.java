package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;


@Entity
public class Game implements BaseEntity {

    @Id
    private Long id;

    @Override
    public Long getId() {
        return 0L;
    }

    @Override
    public void setId(Long id) {

    }

}
