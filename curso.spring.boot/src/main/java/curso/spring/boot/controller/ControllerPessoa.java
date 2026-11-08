package curso.spring.boot.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import curso.spring.boot.model.Pessoa;
import curso.spring.boot.service.PessoaService;

@Controller
public class ControllerPessoa {
	
	// caminho padrão que a aplicação vai redirecionar para o cadastro de pessoa
	private static  final String PATH="cadastro/cadastropessoa";
	
	@Autowired
	private PessoaService pessoaService;
	
	private Logger logger = Logger.getLogger(ControllerPessoa.class.getName());
	
	@RequestMapping(method = RequestMethod.GET,value = "/cadastropessoa")
	public ModelAndView inicio() {
		ModelAndView modelAndView = new ModelAndView(PATH);
		Pessoa pessoaobj = new Pessoa();
		modelAndView.addObject("pessoaobj", pessoaobj);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
	}
	
	@PostMapping(value = "/salvarpessoa")
	public ModelAndView salvar(Pessoa pessoa) {
		pessoaService.salvar(pessoa);
		
		ModelAndView modelAndView = new ModelAndView(PATH);
		Pessoa pessoaobj = new Pessoa();
		modelAndView.addObject("pessoaobj", pessoaobj);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
	}
	
	@GetMapping(value = "/listarpessoas")
	public ModelAndView listarPessoas() {
		ModelAndView modelAndView = new ModelAndView(PATH);
		Pessoa pessoaobj = new Pessoa();
		modelAndView.addObject("pessoaobj", pessoaobj);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
		
	}
	@GetMapping(value = "/editarPessoa/{idPessoa}")
	public ModelAndView editar(@PathVariable ("idPessoa") Long idPessoa) {
		ModelAndView modelAndView = new ModelAndView(PATH);
		Pessoa pessoaobj = pessoaService.buscaPorId(idPessoa);
		modelAndView.addObject("pessoaobj", pessoaobj);
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
		
	}
	@GetMapping(value = "/deletarPessoa/{idPessoa}")
	public ModelAndView deletar(@PathVariable("idPessoa") Long idPessoa) {
		ModelAndView modelAndView = new ModelAndView(PATH);
		pessoaService.deletar(idPessoa);
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("pessoas", pessoaService.listarPessoas());
		return modelAndView;
	}
	
	@PostMapping(value = "/buscarPorNome")
	public ModelAndView buscaPorNome(@RequestParam("pesquisarNome") String pesquisarNome) {
		ModelAndView modelAndView = new ModelAndView(PATH);
		logger.info("resgatando o nome informado: "+pesquisarNome);
		
		modelAndView.addObject("pessoaobj", new Pessoa());
		modelAndView.addObject("pessoas", pessoaService.listarPessoaPorNome(pesquisarNome));
		return modelAndView;
	}
}
