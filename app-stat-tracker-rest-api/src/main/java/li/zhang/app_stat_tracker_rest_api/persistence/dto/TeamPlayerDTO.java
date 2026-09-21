package li.zhang.app_stat_tracker_rest_api.persistence.dto;


import java.util.Set;

public record TeamPlayerDTO(Long id,
                        String userName,
                        String firstName,
                        String lastName,
                        String email,
                        String phone,
                        String sex,
                        Set<PlayerStatsDTO> playerStats) {}