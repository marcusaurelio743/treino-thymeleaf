package curso.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import curso.spring.boot.model.Pessoa;
import curso.spring.boot.service.PessoaService;

@Controller
public class ControllerPessoa {
	
	// caminho padrão que a aplicação vai redirecionar para o cadastro de pessoa
	private static  final String PATH="cadastro/cadastropessoa";
	
	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView(PATH);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
	}
	
	@PostMapping(value = "/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaService.salvar(pessoa);
		
		ModelAndView modelAndView = new ModelAndView(PATH);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
	}
	
	@GetMapping(value = "/listarpessoas")
	public ModelAndView listarPessoas() {
		ModelAndView modelAndView = new ModelAndView(PATH);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
		
	}
}
