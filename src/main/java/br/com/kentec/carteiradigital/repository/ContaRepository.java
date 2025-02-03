package br.com.kentec.carteiradigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.kentec.carteiradigital.domain.Contas;

public interface ContaRepository extends JpaRepository<Contas, Long> {
	
	@Query("SELECT c FROM Contas c WHERE c.status = 'ATIVO' ")
	List<Contas> selectContasAtivas();
	
}
