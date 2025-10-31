package co.edu.uco.nese.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "co.edu.uco.nose" })
@SpringBootApplication
public class ApiNeseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiNeseApplication.class, args);
	}

}
