package co.usa.ciclo3mnnq.ciclo3mnnq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.ciclo3mnnq.ciclo3mnnq.model"})
@SpringBootApplication
public class Ciclo3mnnqApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3mnnqApplication.class, args);
	}

}
