package com.mgmoura.contasapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.dtos.UsuarioDto;
import com.mgmoura.contasapp.entities.Conta;
import com.mgmoura.contasapp.repositories.ContaRepository;

@Controller
public class ExcluirContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@RequestMapping(value = "/admin/excluir-conta")
	public ModelAndView excluirConta(HttpServletRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView("admin/consultar-conta");
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario_auth");
			
			Conta conta = contaRepository.findById(id);
			
			if(conta != null && conta.getUsuario().getId() == usuarioDto.getId()) {
				
				contaRepository.delete(id);
				
				modelAndView.addObject("mensagem_sucesso" , "Conta '" + conta.getNome() + "' , excluída com sucesso");
			}
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro" , e.getMessage());
		}
		
		return modelAndView;
		
	}

}
