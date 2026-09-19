package li.zhang.app_stat_tracker_rest_api.persistence.mapper;

import  li.zhang.app_stat_tracker_rest_api.persistence.dto.PlayerDTO;
import  li.zhang.app_stat_tracker_rest_api.persistence.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {
    PlayerDTO toDTO(Player player);
    Player toEntity(PlayerDTO dto);
    List<PlayerDTO> toDTOList(List<Player> players);
    List<PlayerDTO> toDTOList(Page<Player> players);

    List<Player> toEntityList(List<PlayerDTO> playerDTOs);
}