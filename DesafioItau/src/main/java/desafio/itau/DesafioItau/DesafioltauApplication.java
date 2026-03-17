package desafio.itau.DesafioItau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"desafio.itau", "desafio.password"})
@EnableJpaRepositories("desafio.password.repository")
@EntityScan("desafio.password.model")
public class DesafioltauApplication {
	public static void main(String[] args) {
		SpringApplication.run(DesafioltauApplication.class, args);
	}
}