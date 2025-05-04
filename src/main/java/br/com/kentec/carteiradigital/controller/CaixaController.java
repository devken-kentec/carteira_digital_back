package br.com.kentec.carteiradigital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.kentec.carteiradigital.domain.Caixa;
import br.com.kentec.carteiradigital.service.CaixaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/carteira-digital/api/caixa/v1")
public class CaixaController {
	
	@Autowired
	private CaixaService css;
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void gravar(@RequestBody Caixa caixa) {
		 css.salvar(caixa);
	}
	
	
}
