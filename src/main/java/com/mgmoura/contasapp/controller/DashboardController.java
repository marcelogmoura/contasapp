package com.mgmoura.contasapp.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mgmoura.contasapp.dtos.UsuarioDto;
import com.mgmoura.contasapp.entities.Conta;
import com.mgmoura.contasapp.repositories.ContaRepository;

@Controller
public class DashboardController {
	
	@Autowired
	ContaRepository contaRepository;
	
	@RequestMapping(value = "/admin/dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/dashboard");
		
		try {
			
			UsuarioDto usuarioDto = (UsuarioDto) request.getSession().getAttribute("usuario_auth");
			
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			Date primeiroDiaDoMes = calendar.getTime();
			
			calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
			Date ultimoDiaDoMes = calendar.getTime();
			
			List<Conta> lista = contaRepository.findAll(primeiroDiaDoMes, ultimoDiaDoMes, usuarioDto.getId());
			
			Double totalReceitas = 0.0;
			Double totalDespesas = 0.0;
			
			for (Conta conta : lista) {
				if(conta.getTipo() == 1 ) totalReceitas += conta.getValor();
				else if (conta.getTipo() == 2) totalDespesas += conta.getValor();				
			}
			
			modelAndView.addObject("listagem_contas" , lista);
			modelAndView.addObject("total_receitas" , totalReceitas);
			modelAndView.addObject("total_despesas" , totalDespesas);
			modelAndView.addObject("data_inicio" , new SimpleDateFormat("yyyy-MM-dd").format(primeiroDiaDoMes));
			modelAndView.addObject("data_fim" , new SimpleDateFormat("yyyy-MM-dd").format(ultimoDiaDoMes));
			
			
		}catch (Exception e) {
			modelAndView.addObject("mensagem_erro" , e.getMessage());
		}
		
		return modelAndView;
	}

}
