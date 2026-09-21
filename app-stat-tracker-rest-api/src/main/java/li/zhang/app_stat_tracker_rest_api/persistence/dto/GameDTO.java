package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import java.util.Set;

public record GameDTO(Long id,
                      String gameType,
                      String gameTime,
                      String gameLocation,
                      TeamViewTeamDTO homeTeam,
                      TeamViewTeamDTO awayTeam,
                      Set<PlayerStatsDTO> playerStats
                      ) {}
