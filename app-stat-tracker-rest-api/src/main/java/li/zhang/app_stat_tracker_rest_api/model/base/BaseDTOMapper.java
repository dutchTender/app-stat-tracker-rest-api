package li.zhang.app_stat_tracker_rest_api.model.base;


import li.zhang.app_stat_tracker_rest_api.utils.config.MapperAvoidCycleContext;
import org.mapstruct.Context;

import java.util.List;

public interface BaseDTOMapper<T, K>{
    K toDTO(T entity,  @Context MapperAvoidCycleContext context);
    T toEntity(K dto, @Context MapperAvoidCycleContext context);
    List<K> toDTOList(List<T> entityList, @Context MapperAvoidCycleContext context);
    List<T> toEntityList(List<K> dtoList, @Context MapperAvoidCycleContext context);
}
