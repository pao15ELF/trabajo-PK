package ar.edu.unju.fi.TPFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ar.edu.unju.fi.TPFinal.model.Usuario;
import ar.edu.unju.fi.TPFinal.repository.IUsuarioRepository;
import ar.edu.unju.fi.TPFinal.service.IUsuarioService;

@SpringBootTest
class UsuarioTest {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired 
	IUsuarioRepository usuarioRepository;
	
	@Autowired 
	IUsuarioService usuarioService;

	@Test
	void testGuardarUsuario()
	{
		Usuario usuario= new Usuario();
		
		//usuario.setNombreUsuario("paola15ELF");
		//usuario.setPassword(encoder.encode("paola1518"));
		//usuario.setRolUsuario("Administrador");
		
		usuario.setNombreUsuario("karen1415");
		usuario.setPassword(encoder.encode("daiana1415"));
		usuario.setRolUsuario("Editor");
		
		usuarioService.guardarUsuario(usuario);
		assertEquals(usuario.getNombreUsuario(),usuario.getNombreUsuario());
	}
}
