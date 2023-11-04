package br.com.controle.de.gastos.controle.de.gastos.DTO;

import br.com.controle.de.gastos.controle.de.gastos.Entities.UsuarioRole;

public record UsuarioDTO (String nome,String login,String plvPass,UsuarioRole role){
}
