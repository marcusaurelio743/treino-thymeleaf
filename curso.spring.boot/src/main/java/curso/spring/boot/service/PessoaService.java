package curso.spring.boot.service;

import java.util.List;
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
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}

	public Pessoa buscaPorId(Long idPessoa) {
		logger.info("buscando Pessoa pelo id: "+idPessoa);
		Pessoa p = pessoaRepository.findById(idPessoa).orElseThrow(null);
		return p;
	}

	public void deletar(Long idPessoa) {
		logger.info("Apagando Pessoa pelo id: "+idPessoa);
		pessoaRepository.deleteById(idPessoa);
		
	}
}
