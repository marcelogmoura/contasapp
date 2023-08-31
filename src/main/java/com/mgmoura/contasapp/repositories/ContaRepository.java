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
				
		String sql = "insert into conta(nome, descricao, data, valor, tipo, usuario_id) values(?,?,?,?,?,?)";

		
		Object[] params = {
				conta.getNome(),
				conta.getDescricao(),
				new java.sql.Date(conta.getData().getTime()),
				conta.getValor(),
				conta.getTipo(),
				conta.getUsuario().getId()
			};
		
		jdbcTemplate.update(sql , params);
	}
	

}




