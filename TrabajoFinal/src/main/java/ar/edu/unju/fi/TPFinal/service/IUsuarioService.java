package ar.edu.unju.fi.TPFinal.service;

import ar.edu.unju.fi.TPFinal.model.Usuario;

public interface IUsuarioService {
	
	public void guardarUsuario(Usuario usuario);

	public Usuario findByNombreUsuario(String nombreUsuario);
}
