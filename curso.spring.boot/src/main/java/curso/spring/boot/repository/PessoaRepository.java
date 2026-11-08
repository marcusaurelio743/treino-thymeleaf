package curso.spring.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.spring.boot.model.Pessoa;

@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	
	@Query("select p from Pessoa p where LOWER(p.nome)  LIKE LOWER(CONCAT('%', ?1, '%'))")
	List<Pessoa> buscaPorNome(String pesquisarNome);

}
