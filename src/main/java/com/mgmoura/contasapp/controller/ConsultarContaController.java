package com.mgmoura.contasapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultarContaController {
	
	@RequestMapping(value = "/admin/consultar-conta")
	public ModelAndView consultarConta() {
		ModelAndView modelAndView = new ModelAndView("admin/consultar-conta");
		return modelAndView;
	}

}
