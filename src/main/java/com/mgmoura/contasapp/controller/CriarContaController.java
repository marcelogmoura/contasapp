package com.mgmoura.contasapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CriarContaController {
	
	@RequestMapping(value = "/criar-conta")
	public ModelAndView criarConta() {
		ModelAndView modelAndView = new ModelAndView("criar-conta");
		return modelAndView;
	}

}
