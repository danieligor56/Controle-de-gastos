package br.com.controle.de.gastos.controle.de.gastos.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Entradas;

@Repository
public interface EntradaRepository extends JpaRepository<Entradas, Long> {
	
	Entradas deleteById(long id);
	
	List<Entradas> findByUsuarioId(long id);
	
}
