package li.zhang.app_stat_tracker_rest_api.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import li.zhang.app_stat_tracker_rest_api.AppStatTrackerRestApiApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = AppStatTrackerRestApiApplication.class)
public class CucumberConfig {

}