package br.com.controle.de.gastos.controle.de.gastos.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.springframework.security.config.annotation.web.headers.HttpPublicKeyPinningDsl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Usuario implements UserDetails{
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_usuario",unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@PrimaryKeyJoinColumn
	private long id;
	
	@NotNull
	@Column(name = "nome",unique = true,nullable = false)
	private String nome;
	
	@NotNull
	//Vai ser email. 
	@Column(name = "login",unique = true,nullable = false)
	private String login;
	
	@NotNull
	@Column(name = "plvPass",nullable = false)
	private String plvPass;
	
	@Getter @Setter
	private UsuarioRole role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		if (this.role == UsuarioRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
			else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
					
				 
		}
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return plvPass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}


	public Usuario(@NotNull String nome, @NotNull String login, @NotNull String plvPass, UsuarioRole role) {
		super();
		this.nome = nome;
		this.login = login;
		this.plvPass = plvPass;
		this.role = role;
	}
		
}
