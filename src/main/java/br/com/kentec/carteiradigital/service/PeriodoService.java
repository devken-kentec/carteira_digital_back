package br.com.kentec.carteiradigital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.carteiradigital.domain.Periodos;
import br.com.kentec.carteiradigital.repository.PeriodoRepository;

@Service
public class PeriodoService {
	
	@Autowired
	private PeriodoRepository pr;
	
	public Iterable<Periodos> listarPeriodos() {
		return pr.selectPeriodoAtivo();
	}
}
