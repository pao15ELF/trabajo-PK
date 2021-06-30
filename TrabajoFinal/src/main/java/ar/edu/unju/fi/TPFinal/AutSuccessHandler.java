package ar.edu.unju.fi.TPFinal;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutSuccessHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		boolean esAdmin=false;
		boolean esEditor=false;
		
		Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();
		
		//situacion en la que un usuario tiene varios rol
		for(GrantedAuthority grantedAuthority: authorities)
		{
			if(grantedAuthority.getAuthority().equals("Administrador"))
			{
				esAdmin=true;
				break;
			}else if(grantedAuthority.getAuthority().equals("Editor")) {
				esEditor=true;
				break;
			}
		}
		//
		
		if (esAdmin)
		{
			redirectStrategy.sendRedirect(request, response, "/index");
		}else if(esEditor) {
			redirectStrategy.sendRedirect(request, response, "/product/nuevo");
		}else {
			throw new IllegalStateException();
		}
		
	}

}
