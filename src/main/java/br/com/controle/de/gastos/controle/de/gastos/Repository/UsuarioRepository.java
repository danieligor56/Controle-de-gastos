package br.com.controle.de.gastos.controle.de.gastos.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controle.de.gastos.controle.de.gastos.DTO.UsuarioDTO;
import br.com.controle.de.gastos.controle.de.gastos.Entities.Usuario;
import jakarta.persistence.Id;
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Id> {

//	public Usuario addUsuario(UsuarioDTO usuarioDTO);

}
