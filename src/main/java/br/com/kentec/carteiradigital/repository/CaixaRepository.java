package br.com.kentec.carteiradigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kentec.carteiradigital.domain.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Long>{

}
