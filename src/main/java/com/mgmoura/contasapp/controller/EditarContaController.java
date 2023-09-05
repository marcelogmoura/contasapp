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
import com.mgmoura.contasapp.repositories.ContaRepository;

@Controller
public class EditarContaController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@RequestMapping(value = "/admin/editar-conta")
	public ModelAndView editarConta(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/editar-conta");
		
		try {
			
			Integer id = Integer.parseInt(request.getParameter("id"));
			
			UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario_auth");	
			
			Conta conta = contaRepository.findById(id);
			
			if(conta != null && conta.getUsuario().getId() == usuarioDto.getId()) {
				
				modelAndView.addObject("id" , conta.getId());
				modelAndView.addObject("nome" , conta.getNome());
				modelAndView.addObject("data" , new SimpleDateFormat("yyyy-MM-dd").format(conta.getData()));
				modelAndView.addObject("valor" , conta.getValor());
				modelAndView.addObject("descricao" , conta.getDescricao());
				modelAndView.addObject("tipo" , conta.getTipo());
				
				
			}else {
				modelAndView.addObject("redirect:/admin/consultar-conta");				
			}			
			
		}catch (Exception e) {			
			modelAndView.addObject("mensagem_erro" , e.getMessage());
		}
		
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/admin/editar-conta-post" , method = RequestMethod.POST)
	public ModelAndView editarContaPost(HttpServletRequest request) {
				
		ModelAndView modelAndView = new ModelAndView("admin/consultar-conta");
		
		try {
			Conta conta = new Conta();
			
			conta.setId(Integer.parseInt(request.getParameter("id")));
			conta.setNome(request.getParameter("nome"));
			conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("data")));
			conta.setValor(Double.parseDouble(request.getParameter("valor")));
			conta.setDescricao(request.getParameter("descricao"));
			
			contaRepository.update(conta);
			
			modelAndView.addObject("mensagem_sucesso" , "Conta atualizada com sucesso");
			
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro" , e.getMessage());
		}
		
		return modelAndView;
		
	}
}




