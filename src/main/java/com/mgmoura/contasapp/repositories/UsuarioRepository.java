package com.mgmoura.contasapp.repositories;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mgmoura.contasapp.entities.Usuario;

public class UsuarioRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public UsuarioRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void create(Usuario usuario) throws Exception{
		
		String sql = "insert into usuario (nome, email, senha) values(?,?,?)";

		
		Object[] params = {
				usuario.getNome(),
				usuario.getEmail(),
				usuario.getSenha()
		};
		
		jdbcTemplate.update(sql , params);
	}

}
