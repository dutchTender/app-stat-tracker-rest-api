package li.zhang.app_stat_tracker_rest_api.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDTO {
    Long id;
    String teamName;
    String teamCoachName;
    String teamSponsors;
}
