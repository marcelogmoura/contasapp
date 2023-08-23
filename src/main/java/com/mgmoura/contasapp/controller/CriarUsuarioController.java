package com.mgmoura.contasapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.dtos.CriarUsuarioDto;
import com.mgmoura.contasapp.entities.Usuario;
import com.mgmoura.contasapp.helpers.MD5Helper;
import com.mgmoura.contasapp.repositories.UsuarioRepository;

@Controller
public class CriarUsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/criar-usuario")
	public ModelAndView criarUsuario() {
		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		modelAndView.addObject("dto" , new CriarUsuarioDto());
		return modelAndView;
	}
	
	@RequestMapping(value = "/criar-usuario-post", method = RequestMethod.POST)
	public ModelAndView criarUsuarioPost(CriarUsuarioDto dto) {

		ModelAndView modelAndView = new ModelAndView("criar-usuario");
		
		try {
			
			Usuario usuario = new Usuario();
			
			usuario.setNome(dto.getNome());
			usuario.setEmail(dto.getEmail());
			usuario.setSenha(MD5Helper.encrypt(dto.getSenha()));
			
			if(usuarioRepository.find(dto.getEmail()) !=null) {
				modelAndView.addObject("mensagem_erro" , "E-mail já cadastrado");
			}else {
				usuarioRepository.create(usuario);
				dto = new CriarUsuarioDto();
				modelAndView.addObject("mensagem_sucesso" , "Usuário criado");
			}
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro" , "Erro: " + e.getMessage());
		}
		
		modelAndView.addObject("dto", dto);
		return modelAndView;
	}

}


