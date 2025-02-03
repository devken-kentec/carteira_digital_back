package br.com.kentec.carteiradigital.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.kentec.carteiradigital.DTO.LancamentosDTO;
import br.com.kentec.carteiradigital.domain.Contas;
import br.com.kentec.carteiradigital.domain.Lancamentos;
import br.com.kentec.carteiradigital.domain.Periodos;
import br.com.kentec.carteiradigital.domain.User;
import br.com.kentec.carteiradigital.repository.ContaRepository;
import br.com.kentec.carteiradigital.repository.LancamentoRepository;
import br.com.kentec.carteiradigital.repository.PeriodoRepository;
import br.com.kentec.carteiradigital.repository.UserRepository;

@Service
public class LancamentoService {
	
	@Autowired
	private LancamentoRepository lr;
	
	@Autowired
	private PeriodoRepository pr;
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private ContaRepository cr;
	
	public Optional<LancamentosDTO> findById(Long id){
		return lr.findById(id).map(LancamentosDTO::new);
	}
	
	public Iterable<LancamentosDTO> listarLancamentosReceitasAtivo(String natureza, String descricao ,String periodo){
		
		pr.verificaPeriodoAtivo(periodo).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lançamento Fora do Periodo!"));
		
		return lr.listarLancamentosReceitasAtivo(natureza, descricao).stream().map(LancamentosDTO::new).collect(Collectors.toList());
	}
	
	public Iterable<Lancamentos> listarLancamentosDepesasAtivo(String natureza, String periodo){
		
		pr.verificaPeriodoAtivo(periodo).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lançamento Fora do Periodo!"));
		
		return lr.listarLancamentosDepesasAtivo(natureza);
	}
	
	public Lancamentos save(LancamentosDTO lancamentoDTO) {
		Periodos periodo = pr.verificaPeriodoAtivo(lancamentoDTO.getPeriodo()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lançamento Fora do Periodo!"));
		
		User user = ur.findById(lancamentoDTO.getUser()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não Encontrado!"));
		
		Contas conta = cr.findById(lancamentoDTO.getConta()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não Encontrada!"));
	
		Lancamentos lancamento = new Lancamentos();
		lancamento.setUser(user);
		lancamento.setNaturezaDespesa(lancamentoDTO.getNaturezaDespesa());
		lancamento.setDescricao(lancamentoDTO.getDescricao());
		lancamento.setConta(conta);
		lancamento.setTipoDespesa(lancamentoDTO.getTipoDespesa());
		lancamento.setDataPagamento(lancamentoDTO.getDataPagamento());
		lancamento.setDataVencimento(lancamentoDTO.getDataVencimento());
		lancamento.setDataRecebimento(lancamentoDTO.getDataRecebimento());
		lancamento.setStatusPagamento(lancamentoDTO.getStatusPagamento());
		lancamento.setValor(lancamentoDTO.getValor());
		lancamento.setStatus(lancamentoDTO.getStatus());
		lancamento.setPeriodo(periodo.getMes());
		return lr.save(lancamento);
	}
	
	public Lancamentos update(LancamentosDTO lancamentoDTO) {
		Periodos periodo = pr.verificaPeriodoAtivo(lancamentoDTO.getPeriodo()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lançamento Fora do Periodo!"));
		
		User user = ur.findById(lancamentoDTO.getUser()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não Encontrado!"));
		
		Contas conta = cr.findById(lancamentoDTO.getConta()).orElseThrow(()->
		new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta não Encontrada!"));
		Optional<Lancamentos> lancamento = lr.findById(lancamentoDTO.getId());
		
		if(lancamento.isPresent()) {
			lancamento.get().setUser(user);
			lancamento.get().setNaturezaDespesa(lancamentoDTO.getNaturezaDespesa());
			lancamento.get().setDescricao(lancamentoDTO.getDescricao());
			lancamento.get().setConta(conta);
			lancamento.get().setTipoDespesa(lancamentoDTO.getTipoDespesa());
			lancamento.get().setDataPagamento(lancamentoDTO.getDataPagamento());
			lancamento.get().setDataVencimento(lancamentoDTO.getDataVencimento());
			lancamento.get().setDataRecebimento(lancamentoDTO.getDataRecebimento());
			lancamento.get().setStatusPagamento(lancamentoDTO.getStatusPagamento());
			lancamento.get().setValor(lancamentoDTO.getValor());
			lancamento.get().setStatus(lancamentoDTO.getStatus());
			lancamento.get().setPeriodo(periodo.getMes());
		}
		return lr.save(lancamento.get());
	}
}
