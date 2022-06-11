package com.project.Ebanking_BackEnd.payload.response;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String redirectUrl = null;
		System.out.println("here 1");
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("role " + grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("ROLE_AGENT")) {
				redirectUrl = "/agent";
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_CLIENT")) {
				redirectUrl = "/client";
				break;
			}else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				redirectUrl = "/admin";
				break;
			}
		}
		System.out.println("redirectUrl " + redirectUrl);
		if (redirectUrl == null) {
			System.out.println("here 2");
			throw new IllegalStateException();
		}
		System.out.println(redirectUrl);
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);		
	}

}
