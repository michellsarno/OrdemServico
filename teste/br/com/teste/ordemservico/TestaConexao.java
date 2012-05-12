package br.com.teste.ordemservico;

import br.com.jdbc.ordemservico.DaoFactory;

public class TestaConexao {

	public static void main(String[] args) {
		
		DaoFactory daoFactory = new DaoFactory();
		
		daoFactory.getConnection();
		
	}
	
}
