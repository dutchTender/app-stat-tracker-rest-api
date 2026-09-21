package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import java.util.Set;

public record PlayerViewTeamDTO(Long id,
                                String teamName,
                                String teamCoachName,
                                String teamSponsors,
                                Set<GameDTO> homeGames,
                                Set<GameDTO> awayGames
                         ) {}