package br.com.kentec.carteiradigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.carteiradigital.DTO.ContasDTO;
import br.com.kentec.carteiradigital.domain.Contas;
import br.com.kentec.carteiradigital.service.ContaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carteira-digital/api/conta/v1")
public class ContaController {
	
	@Autowired
	private ContaService cs;
	
	@GetMapping("/listarContas")
	public ResponseEntity<Iterable<Contas>> listarContas(){
		return ResponseEntity.ok(cs.listarContas());
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Contas gravar(@RequestBody ContasDTO contaDTO) {
		return cs.save(contaDTO);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Contas update(@RequestBody ContasDTO contaDTO) {
		return cs.update(contaDTO);
	}
}
