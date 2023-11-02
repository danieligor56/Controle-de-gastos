package br.com.controle.de.gastos.controle.de.gastos.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Dividas;

@Repository
public interface DividasRepository extends JpaRepository<Dividas,Long>{

	List <Dividas> findByUsuarioId(long id);

}
