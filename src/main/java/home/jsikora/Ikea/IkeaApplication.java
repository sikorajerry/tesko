package home.jsikora.Ikea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaRepositories("home.jsikora.repository")
@EntityScan("home.jsikora.dto")
@EnableScheduling
@SpringBootApplication(scanBasePackages = "home.jsikora")
public class IkeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IkeaApplication.class, args);
	}
}
