package br.com.jdbc.ordemservico;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoFactory {
	
	public Connection getConnection(){

		Connection retorno;

		try {
			
			retorno = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "P@ssw0rd");
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		return retorno;
	}
}
