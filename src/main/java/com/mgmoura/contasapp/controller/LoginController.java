package com.mgmoura.contasapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.entities.Usuario;
import com.mgmoura.contasapp.repositories.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/login-post" , method = RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		try {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = usuarioRepository.find(email, senha);
			
			if(usuario != null) {
				
			}else {
				modelAndView.addObject("mensagem_erro", "Acesso negado");
				
			}
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		return modelAndView;
		
	}

}



