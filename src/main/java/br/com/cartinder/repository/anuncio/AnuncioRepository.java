package br.com.cartinder.repository.anuncio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cartinder.model.anuncio.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

	@Query("SELECT an FROM Anuncio an "
			+ "WHERE an.carro.marca = :paramMarca ")
	public List<Anuncio> buscaAnuncioPorMarca(
			@Param("paramMarca") String paramMarca);
		
	@Query("SELECT an FROM Anuncio an "
			+ "WHERE an.carro.ano = :paramAno ")
	public List<Anuncio> buscaAnuncioPorAno(
			@Param("paramAno") Integer ano);
	
	@Query("SELECT an FROM Anuncio an "
			+ "WHERE an.carro.marca = :paramMarca "
			+ "AND an.carro.ano = :paramAno")
	public List<Anuncio> buscaAnuncioPorMarcaAno(
			@Param("paramMarca") String paramMarca,
			@Param("paramAno") Integer ano);
}
