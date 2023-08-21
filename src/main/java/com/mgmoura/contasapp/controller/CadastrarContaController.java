package com.mgmoura.contasapp.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.entities.Conta;
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
	
	// -->> verificar com a aula
	
	
	@RequestMapping(value = "/admin/cadastrar-conta-post" )
	public ModelAndView cadastrarContaPost(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-conta");
		
		try {
			
			Conta conta = new Conta();
			
			conta.setNome(request.getParameter("nome"));
			conta.setDescricao(request.getParameter("descricao"));
			// conta.setData(request.getParameter(new SimpleDateFormat("yyyy-MM-dd").parse("data")));
			
			
			contaRepository.create(conta);
			
			modelAndView.addObject("mensagem" , "Conta cadastrada");
			
			
		}catch (Exception e) {
			
			modelAndView.addObject("mensagem" , "Erro:" + e.getMessage());
		}
		
		return modelAndView;
		
	}

}
