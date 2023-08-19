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
public class CriarContaController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/criar-conta")
	public ModelAndView criarConta() {
		ModelAndView modelAndView = new ModelAndView("criar-conta");
		return modelAndView;
	}
	
	@RequestMapping(value = "/criar-conta-post", method = RequestMethod.POST)
	public ModelAndView criarContaPost(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("criar-conta");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(request.getParameter("nome"));
			usuario.setEmail(request.getParameter("email"));
			usuario.setSenha(request.getParameter("senha"));
			
			usuarioRepository.create(usuario);
			
			modelAndView.addObject("mensagem" , "Usuário criado");
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem" , "Erro: " + e.getMessage());
		}
		
		return modelAndView;
	}

}


