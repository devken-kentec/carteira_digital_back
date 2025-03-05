package br.com.kentec.carteiradigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.kentec.carteiradigital.domain.Lancamentos;

public interface LancamentoRepository extends JpaRepository<Lancamentos, Long> {
	
	@Query("SELECT l FROM Lancamentos l WHERE l.naturezaDespesa = :natureza AND l.periodo = :periodo ")
	List<Lancamentos> listarLancamentosDepesasAtivo(@Param("natureza") String natureza,
			                                        @Param("periodo") String periodo);
	
	@Query("SELECT l FROM Lancamentos l WHERE l.naturezaDespesa = :natureza AND l.conta.descricao = :descricao AND l.periodo = :periodo ")
	List<Lancamentos> listarLancamentosReceitasAtivo(@Param("natureza") String natureza,
													 @Param("descricao") String descricao,
													 @Param("periodo") String periodo);
}
