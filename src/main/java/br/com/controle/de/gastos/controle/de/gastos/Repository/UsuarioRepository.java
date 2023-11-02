package br.com.controle.de.gastos.controle.de.gastos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
	Usuario findById(long id);
	

}
