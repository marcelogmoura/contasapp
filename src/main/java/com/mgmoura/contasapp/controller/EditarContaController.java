package com.mgmoura.contasapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditarContaController {
	
	@RequestMapping(value = "/admin/editar-conta")
	public ModelAndView editarConta() {
		ModelAndView modelAndView = new ModelAndView("admin/editar-conta");
		return modelAndView;
	}

}
