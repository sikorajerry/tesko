package home.jsikora.Ikea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "home.jsikora")


@EnableScheduling

public class IkeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IkeaApplication.class, args);
	}
}
