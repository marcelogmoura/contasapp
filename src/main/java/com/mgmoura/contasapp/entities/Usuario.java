package com.mgmoura.contasapp.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario {
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private List<Conta> contas;
	

}
