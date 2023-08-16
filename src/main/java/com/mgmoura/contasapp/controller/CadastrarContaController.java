package com.mgmoura.contasapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastrarContaController {
	
	@RequestMapping(value = "/admin/cadastrar-conta")
	public ModelAndView cadastrarConta() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastrar-conta");
		return modelAndView;
	}

}
