package br.com.kentec.carteiradigital.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.carteiradigital.DTO.LancamentosDTO;
import br.com.kentec.carteiradigital.domain.Lancamentos;
import br.com.kentec.carteiradigital.service.LancamentoService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carteira-digital/api/lancamento/v1")
public class LancamentoController {
	
	@Autowired
	private LancamentoService ls; 
	
	@GetMapping("/recuperar/{id}")
	public ResponseEntity<Optional<LancamentosDTO>> findById(@PathVariable("id") Long id){
		return ResponseEntity.ok(ls.findById(id));
	}
	
	@GetMapping("/listar/receita")
	public ResponseEntity<Iterable<LancamentosDTO>> listarLancamentosReceitaAtivo(
														@RequestParam("natureza") String natureza,
														@RequestParam("descricao") String descricao,
														@RequestParam("periodo") String periodo){
		return ResponseEntity.ok(ls.listarLancamentosReceitasAtivo(natureza, descricao, periodo));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Iterable<Lancamentos>> listarLancamentosDepesasAtivo(
														@RequestParam("natureza") String natureza,
														@RequestParam("periodo") String periodo){
		return ResponseEntity.ok(ls.listarLancamentosDepesasAtivo(natureza, periodo));
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Lancamentos gravar(@RequestBody LancamentosDTO lancamentoDTO) {
		return ls.save(lancamentoDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Lancamentos update(@RequestBody LancamentosDTO lancamentoDTO) {
		return ls.update(lancamentoDTO);
	}
}
