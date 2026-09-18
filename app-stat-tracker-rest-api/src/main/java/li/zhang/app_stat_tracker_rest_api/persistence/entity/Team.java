package li.zhang.app_stat_tracker_rest_api.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import li.zhang.app_stat_tracker_rest_api.model.base.BaseEntity;


@Entity
public class Team implements BaseEntity {
    @Id
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }
}

