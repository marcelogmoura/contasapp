package com.mgmoura.contasapp.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.dtos.UsuarioDto;
import com.mgmoura.contasapp.entities.Conta;
import com.mgmoura.contasapp.repositories.ContaRepository;

@Controller
public class ConsultarContaController {

	@Autowired
	ContaRepository contaRepository;

	@RequestMapping(value = "/admin/consultar-conta")
	public ModelAndView consultarConta() {
		ModelAndView modelAndView = new ModelAndView("admin/consultar-conta");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/consultar-conta-post", method = RequestMethod.POST)
	public ModelAndView consultarContaPost(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/consultar-conta");

		try {

			String dataInicio = request.getParameter("dataInicio");
			String dataFim = request.getParameter("dataFim");

			UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario_auth");

			List<Conta> contas = contaRepository.findAll(new SimpleDateFormat("yyyy-MM-dd").parse(dataInicio),
					new SimpleDateFormat("yyyy-MM-dd").parse(dataFim), usuarioDto.getId());

			if (contas.size() > 0) {
				modelAndView.addObject("listagem_contas", contas);
			} else {
				modelAndView.addObject("mensagem_alerta", "Nenhuma conta foi encontrada para o período selecionado");
			}
			
			modelAndView.addObject("dt_inicio", dataInicio);
			modelAndView.addObject("dt_fim", dataFim);
			
			
		} catch (Exception e) {
			
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}

		return modelAndView;
	}
}
