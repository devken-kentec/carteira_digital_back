package br.com.kentec.carteiradigital.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.carteiradigital.domain.Periodos;

public interface PeriodoRepository extends JpaRepository<Periodos, Long> {
	
	@Query("SELECT p FROM Periodos p WHERE p.status = 'ATIVO' ")
	List<Periodos> selectPeriodoAtivo();
	
	@Query("SELECT p FROM Periodos p WHERE UPPER(p.mes) LIKE UPPER(:mes) AND p.status = 'ATIVO' ")
	Optional<Periodos> verificaPeriodoAtivo(@Param("mes") String mes);
}	
