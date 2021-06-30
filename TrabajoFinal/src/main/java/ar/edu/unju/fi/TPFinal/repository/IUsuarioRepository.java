package ar.edu.unju.fi.TPFinal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.TPFinal.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long>{
	
	//public List<Usuario> findByUsuario(Usuario usuario);
	
	public Usuario findByNombreUsuario(String nombreUsuario);
}
