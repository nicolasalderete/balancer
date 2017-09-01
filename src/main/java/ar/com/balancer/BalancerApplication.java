package ar.com.balancer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ar.com.balancer.domain.Cliente;
import ar.com.balancer.repository.ClienteRepository;

@SpringBootApplication
public class BalancerApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BalancerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BalancerApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData(ClienteRepository repository) {
		return (args) -> {
			repository.save(new Cliente("Nicolas"));
			repository.save(new Cliente("Martin"));
			repository.save(new Cliente("Lucas"));
			repository.save(new Cliente("Carlos"));
			repository.save(new Cliente("Mariano"));
			repository.save(new Cliente("Alfonso"));
			repository.save(new Cliente("German"));
			repository.save(new Cliente("Alejandro"));
			repository.save(new Cliente("Lucas"));
			repository.save(new Cliente("Carlos"));
			repository.save(new Cliente("Mariano"));
			repository.save(new Cliente("Alfonso"));
			repository.save(new Cliente("German"));
			repository.save(new Cliente("Alejandro"));
			repository.save(new Cliente("Lucas"));
			repository.save(new Cliente("Carlos"));
			repository.save(new Cliente("Mariano"));
			repository.save(new Cliente("Alfonso"));
			repository.save(new Cliente("German"));
			repository.save(new Cliente("Alejandro"));
			
			log.info("Clientes found with findAll():");
			log.info("-------------------------------");
			for (Cliente cliente : repository.findAll()) {
				log.info(cliente.toString());
			}
			log.info("");
			
			// fetch an individual customer by ID
			Cliente cliente = repository.findOne(1L);
			log.info("Cliente found with findOne(1L):");
			log.info("--------------------------------");
			log.info(cliente.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastNameStartsWithIgnoreCase('Nico'):");
			log.info("--------------------------------------------");
			for (Cliente nico : repository.findByNombreStartsWithIgnoreCase("Nico")) {
				log.info(nico.toString());
			}
			log.info("");
		};
	}
}
