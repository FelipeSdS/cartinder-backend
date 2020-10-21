package br.com.cartinder.repository.carro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cartinder.model.carro.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
