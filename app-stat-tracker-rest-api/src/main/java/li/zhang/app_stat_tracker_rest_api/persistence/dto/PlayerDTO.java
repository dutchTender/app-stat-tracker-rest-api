package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import java.util.Set;

public record PlayerDTO(Long id, String userName, String firstName, String lastName, String email, String phone, String sex, TeamDTO team, Set<PlayerStatsDTO> playerStats) {}