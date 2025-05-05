package br.com.kentec.carteiradigital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.carteiradigital.domain.Caixa;
import br.com.kentec.carteiradigital.repository.CaixaRepository;

@Service
public class CaixaService {
	
	@Autowired
	private CaixaRepository cr;
	
	public void salvar(Caixa caixa) {
		cr.save(caixa);
	}
	
	public void alterar(Caixa caixa) {
		cr.save(caixa);
	}
	
	public Iterable<Caixa> listar(){
		return cr.findAll();
	}
	
	public void excluir(Long id) {
		cr.deleteById(id);
	}
}
