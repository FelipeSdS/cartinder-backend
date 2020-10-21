package br.com.cartinder.repository.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cartinder.model.cliente.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
