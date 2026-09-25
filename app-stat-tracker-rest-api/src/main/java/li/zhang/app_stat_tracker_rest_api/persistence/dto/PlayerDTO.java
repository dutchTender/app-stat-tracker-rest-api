package li.zhang.app_stat_tracker_rest_api.persistence.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    Long id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String sex;
    TeamDTO team;
}
