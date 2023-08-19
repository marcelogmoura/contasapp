package com.mgmoura.contasapp.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mgmoura.contasapp.entities.Conta;

public class ContaRepository {

	private JdbcTemplate jdbcTemplate;
	
	public ContaRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Conta conta) throws Exception{
		
		String sql = "insert into conta(nome, descricao, data, valor, tipo) values (?, ?, ?, ?, ? )" ;
		
		Object[] params = {
				conta.getNome(),
				conta.getDescricao(),
				conta.getData(),
				conta.getValor(),
				conta.getTipo()
			
		};
		
		jdbcTemplate.update(sql , params);
	}
	

}




