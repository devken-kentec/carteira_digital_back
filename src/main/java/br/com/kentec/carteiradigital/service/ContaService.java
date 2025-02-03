package br.com.kentec.carteiradigital.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kentec.carteiradigital.DTO.ContasDTO;
import br.com.kentec.carteiradigital.domain.Contas;
import br.com.kentec.carteiradigital.domain.User;
import br.com.kentec.carteiradigital.repository.ContaRepository;
import br.com.kentec.carteiradigital.repository.UserRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository cr;
	
	@Autowired
	private UserRepository ur;
	
	public Iterable<Contas> listarContas() {
		return cr.selectContasAtivas();
	}
	
	public Contas save(ContasDTO contaDTO) {
		
		Optional<User> user = ur.findById(contaDTO.getUser()); 
		Contas conta = new Contas();
		
		if(user.isPresent()) {
			conta.setDescricao(contaDTO.getDescricao());
			conta.setNaturezaConta(contaDTO.getNaturezaConta());
			conta.setTipoConta(contaDTO.getTipoConta());
			conta.setConta(contaDTO.getConta());
			conta.setAgencia(contaDTO.getAgencia());
			conta.setStatus(contaDTO.getStatus());
			conta.setUser(user.get());
		}
		return cr.save(conta);
	}
	
	public Contas update(ContasDTO contaDTO) {
		Optional<Contas> _conta = cr.findById(contaDTO.getId());
		Optional<User> user = ur.findById(contaDTO.getUser()); 
		if(_conta.isPresent()) {
			_conta.get().setDescricao(contaDTO.getDescricao());
			_conta.get().setNaturezaConta(contaDTO.getNaturezaConta());
			_conta.get().setTipoConta(contaDTO.getTipoConta());
			_conta.get().setAgencia(contaDTO.getAgencia());
			_conta.get().setConta(contaDTO.getConta());
			_conta.get().setStatus(contaDTO.getStatus());
			_conta.get().setUser(user.get());
		}
		return cr.save(_conta.get());
	}
}
