package br.com.jdbc.ordemservico;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoFactory {
	
	public Connection getConnection(){

		Connection retorno;

		try {
			
			retorno = DriverManager.getConnection("jdbc:mysql://localhost/fj21", "root", "");
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return retorno;
	}
}
