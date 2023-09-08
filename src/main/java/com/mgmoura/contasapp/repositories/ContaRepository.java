package com.mgmoura.contasapp.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mgmoura.contasapp.entities.Conta;
import com.mgmoura.contasapp.entities.Usuario;

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
	
	public void update(Conta conta) throws Exception {
		
		String sql = "update conta set nome=?, descricao=?, data=?, valor=?, tipo=? where id=? ";
				
		Object[] params = {
				conta.getNome(),
				conta.getDescricao(),
				new java.sql.Date(conta.getData().getTime()),
				conta.getValor(),
				conta.getTipo(),
				conta.getId()				
		};
		
		jdbcTemplate.update(sql , params);
	}
	
	public void delete(Integer id) throws Exception {
		
		String sql = "delete from conta where id=?";
		
		Object[] params = {	id };
				
		jdbcTemplate.update(sql , params);
	}
	
	public List<Conta> findAll (Date dataMin, Date dataMax, Integer usuarioId) throws Exception{
		
		String sql = "select * from conta "
				 + "where data between ? and ? "
				 + "and usuario_id = ? "
				 + "order by data";
		
		Object[] params = {
				new java.sql.Date(dataMin.getTime()),
				new java.sql.Date(dataMax.getTime()),
				usuarioId
		};
		
		List<Conta> contas = jdbcTemplate.query(sql, params, new RowMapper<Conta>() {

			@Override
			public Conta mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Conta conta = new Conta();
				conta.setUsuario(new Usuario());
				
				conta.setId(rs.getInt("id"));
				conta.setNome(rs.getString("nome"));
				conta.setDescricao(rs.getString("descricao"));
				conta.setValor(rs.getDouble("valor"));
				conta.setTipo(rs.getInt("tipo"));
				conta.getUsuario().setId(rs.getInt("usuario_id"));;
				

				try {
					conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("data")));
					
				}catch (Exception e) {
					e.printStackTrace();					
				}
				
				return conta;
			}
			
		});
		
		return contas;
	}
	
	
public Conta findById (Integer id) throws Exception{
		
		String sql = "select * from conta where id = ?" ;
		
		Object[] params = {	id };
		
		List<Conta> contas = jdbcTemplate.query(sql, params, new RowMapper<Conta>() {

			@Override
			public Conta mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Conta conta = new Conta();
				conta.setUsuario(new Usuario());
				
				conta.setId(rs.getInt("id"));
				conta.setNome(rs.getString("nome"));
				conta.setDescricao(rs.getString("descricao"));
				conta.setValor(rs.getDouble("valor"));
				conta.setTipo(rs.getInt("tipo"));
				conta.getUsuario().setId(rs.getInt("usuario_id"));;
				

				try {
					conta.setData(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("data")));
					
				}catch (Exception e) {
					e.printStackTrace();					
				}
				
				return conta;
			}
			
		});
		
		if(contas.size() == 1) {
			return contas.get(0);
		}else {
			return null;
			
		}
	}
}





