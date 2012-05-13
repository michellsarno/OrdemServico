package br.com.teste.ordemservico;

import java.sql.Connection;

import br.com.dao.ordemservico.PessoaDao;
import br.com.jdbc.ordemservico.DaoFactory;
import br.com.vo.ordemservico.PessoaVo;

public class TestaConexao {

	public static void main(String[] args) throws Exception {
		
		DaoFactory daoFactory = new DaoFactory();
		
		Connection connection = daoFactory.getConnection();

		connection.close();
		
		
		PessoaDao pessoaDao = new PessoaDao();
		
		
		PessoaVo pessoaVo = new PessoaVo();
		
		int ultimoCodigo = pessoaDao.getProximoCodigo();
		
		pessoaVo.setCodigo(String.valueOf(ultimoCodigo));
		pessoaVo.setRazaoSocial("Teste 2");
		pessoaVo.setTipoPessoa("2");
		pessoaVo.setCpfCnpj("12345");
		pessoaVo.setTelefone("tel 2");
		
		
		pessoaDao.insertPessoa(pessoaVo);
		
		
	}
	
}
