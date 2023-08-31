package com.mgmoura.contasapp.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.dtos.UsuarioDto;
import com.mgmoura.contasapp.entities.Conta;
import com.mgmoura.contasapp.entities.Usuario;
import com.mgmoura.contasapp.repositories.ContaRepository;

@Controller
public class CadastrarContaController {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@RequestMapping(value = "/admin/cadastrar-conta")
	public ModelAndView cadastrarConta() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-conta");
		return modelAndView;
	}
	
		
	@RequestMapping(value = "/admin/cadastrar-conta-post" , method = RequestMethod.POST)
	public ModelAndView cadastrarContaPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-conta");
		
		try {
			
			Conta conta = new Conta();
			conta.setUsuario(new Usuario());
			
			conta.setNome(request.getParameter("nome"));
			conta.setDescricao(request.getParameter("descricao"));
			conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			conta.setValor(Double.parseDouble(request.getParameter("valor")));
			conta.setDescricao(request.getParameter("descricao"));
			conta.setTipo(Integer.parseInt(request.getParameter("tipo")));
			
			UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario_auth");
			
			conta.getUsuario().setId(usuarioDto.getId());
			
						
			contaRepository.create(conta);
			
			modelAndView.addObject("mensagem" , "Conta cadastrada");
			
			
		}catch (Exception e) {
			
			modelAndView.addObject("mensagem" , "Erro:" + e.getMessage());
		}
		
		return modelAndView;
		
	}

}
