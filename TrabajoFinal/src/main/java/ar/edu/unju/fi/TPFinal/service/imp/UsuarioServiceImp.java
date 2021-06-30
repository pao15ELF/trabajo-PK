package ar.edu.unju.fi.TPFinal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.TPFinal.model.Usuario;
import ar.edu.unju.fi.TPFinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.TPFinal.service.IUsuarioService;

@Service
public class UsuarioServiceImp implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository usuarioRepository;

	

	@Override
	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}



	@Override
	public Usuario findByNombreUsuario(String nombreUsuario) {
		Usuario us= usuarioRepository.findByNombreUsuario(nombreUsuario);
		return us;
	}
	
	

}
