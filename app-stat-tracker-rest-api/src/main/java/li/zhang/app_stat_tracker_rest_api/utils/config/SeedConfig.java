package li.zhang.app_stat_tracker_rest_api.utils.config;

import li.zhang.app_stat_tracker_rest_api.services.SeedService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeedConfig {

    @Bean
    CommandLineRunner initializeData(SeedService dataSeederService) {
        return args -> dataSeederService.seedDB();
    }
}
