package ar.com.balancer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.balancer.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	List<Cliente> findByNombreStartsWithIgnoreCase(String nombre);

}
