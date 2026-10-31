package curso.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import curso.spring.boot.model.Pessoa;
import curso.spring.boot.service.PessoaService;

@Controller
public class ControllerPessoa {
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/cadastropessoa")
	public String inicio() {
		return "cadastro/cadastropessoa";
	}
	
	@PostMapping(value = "/salvarpessoa")
	public String salvar(Pessoa pessoa) {
		pessoaService.salvar(pessoa);
		
		return "cadastro/cadastropessoa";
	}
}
