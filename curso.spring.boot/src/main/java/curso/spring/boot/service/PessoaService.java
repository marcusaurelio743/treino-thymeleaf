package curso.spring.boot.service;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import curso.spring.boot.model.Pessoa;
import curso.spring.boot.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	private Logger logger = Logger.getLogger(PessoaService.class.getName());
	
	public Pessoa salvar(Pessoa pessoa) {
		
		 Pessoa person = pessoaRepository.save(pessoa);
		 logger.info("Pessoa Salva "+person);
		 return person;
		 
	}
}
