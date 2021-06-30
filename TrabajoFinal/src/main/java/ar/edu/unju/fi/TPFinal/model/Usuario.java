package ar.edu.unju.fi.TPFinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Table (name="USUARIOS")
@Component
@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Debe ingresar nombre de usuario")
	@Size(min=8, max=20, message="EL nombre del usuario debe ser como minimo 4 caracteres y como maximo 20")
	@Column(name="nombreUsuario", length=20, nullable=false)
	private String nombreUsuario;
	
	@NotBlank(message="Debe ingresar la contraseña del usuario")
	@Size(min=8,  message="La contraseña debe ser como minimo de 8 caracteres")
	@Column(name="password", nullable=false)
	private String password;
	
	@NotEmpty(message="Debe ingresar el rol del usuario")
	@Column(name="rolUsuario", length=13, nullable=false)
	private String rolUsuario; 
	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id
	 * @param nombreUsuario
	 * @param password
	 * @param rolUsuario
	 */
	public Usuario(Long id,
			@NotEmpty(message = "Debe ingresar nombre de usuario") @Size(min = 8, max = 20, message = "EL nombre del usuario debe ser como minimo 4 caracteres y como maximo 20") String nombreUsuario,
			@NotBlank(message = "Debe ingresar la contraseña del usuario") @Size(min = 8, message = "La contraseña debe ser como minimo de 8 caracteres") String password,
			@NotEmpty(message = "Debe ingresar el rol del usuario") String rolUsuario) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rolUsuario = rolUsuario;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}


	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the rolUsuario
	 */
	public String getRolUsuario() {
		return rolUsuario;
	}


	/**
	 * @param rolUsuario the rolUsuario to set
	 */
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", rolUsuario="
				+ rolUsuario + "]";
	}


	
}
