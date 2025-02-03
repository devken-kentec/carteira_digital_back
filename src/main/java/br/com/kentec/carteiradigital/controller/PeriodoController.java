package br.com.kentec.carteiradigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.carteiradigital.domain.Periodos;
import br.com.kentec.carteiradigital.service.PeriodoService;

@RestController
@RequestMapping("/carteira-digital/api/periodo/v1")
public class PeriodoController {
	
	@Autowired
	private PeriodoService ps;
	
	@GetMapping("/listarPeriodosAtivos")
	public ResponseEntity<Iterable<Periodos>> listarPeriodosAtivos(){
		return ResponseEntity.ok(ps.listarPeriodos());
	}

}
