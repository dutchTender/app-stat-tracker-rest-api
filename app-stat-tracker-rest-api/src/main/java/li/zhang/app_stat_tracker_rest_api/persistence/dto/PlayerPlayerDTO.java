package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import java.util.Set;

public record PlayerPlayerDTO(Long id,
                            String userName,
                            String firstName,
                            String lastName,
                            String email,
                            String phone,
                            String sex,
                            PlayerTeamDTO team,
                            Set<PlayerStatsDTO> playerStats) {}
