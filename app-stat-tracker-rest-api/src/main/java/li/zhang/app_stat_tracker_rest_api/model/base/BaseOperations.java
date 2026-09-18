package li.zhang.app_stat_tracker_rest_api.model.base;

import org.springframework.data.domain.Example;

import java.util.List;

public interface BaseOperations <T extends BaseEntity> {

    T find(final Long id);

    T findByExample(final Example<T> example);

    List<T> findAll();

    List<T> findAllByExample(final Example<T> example);

    List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final Long id);

    void deleteAll();

    long count();


}
