package br.com.dao.ordemservico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jdbc.ordemservico.DaoFactory;
import br.com.vo.ordemservico.PessoaVo;

public class PessoaDao extends BaseDao {

	DaoFactory daoFactory = new DaoFactory();
	Connection connection;
	
	public PessoaDao() {
		this.connection = daoFactory.getConnection();
	}
	
	public enum TipoBusca{
		
		POR_CPF(1),
		POR_NOME(2);
		
		private int valor;
		
		private TipoBusca(int valor){
			this.valor = valor;
		}
		
		public int getValor() {
			return this.valor;
		}
	}
	
	public void insertPessoa(PessoaVo pessoaVo) throws Exception{
		
		StringBuilder qry = new StringBuilder();
		int i = 1;
		
		try {

			qry.append("insert into pessoa");
			qry.append(" ( id, ");
			qry.append(" razao_social, ");
			qry.append(" tipo_pessoa, ");
			qry.append(" cpf_cnpj, ");
			qry.append(" telefone ) ");
		
			qry.append(getValues(qry));
			
			PreparedStatement ps = connection.prepareStatement(qry.toString());

			ps.setInt(i++, Integer.parseInt(pessoaVo.getCodigo()));
			ps.setString(i++, pessoaVo.getRazaoSocial());
			ps.setInt(i++, Integer.parseInt(pessoaVo.getTipoPessoa()));
			ps.setString(i++, pessoaVo.getCpfCnpj());
			ps.setString(i++, pessoaVo.getTelefone());

			validaQuantidadeParametros(qry, i);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public int getProximoCodigo(){
		
		StringBuilder qry = new StringBuilder();
		PreparedStatement ps;
		ResultSet rs;
		int retorno = 0;
		
		qry.append("select max(id) id from pessoa ");
		
		try {
			
			ps = connection.prepareStatement(qry.toString());
			rs = ps.executeQuery();

			if(rs.next()){
				retorno = rs.getInt("id");
			}

			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ++retorno;
	}
	
	public PessoaVo getPessoa(PessoaVo pessoaVo, TipoBusca tipoBusca){
		
		switch (tipoBusca) {
			case POR_CPF:

				return getPessoaPorCpf(pessoaVo);

			case POR_NOME:
				return getPessoaPorNome(pessoaVo);
				
			default:
				return null;
		}
	}


	private PessoaVo getPessoaPorNome(PessoaVo pessoaVo) {
		return null;
	}


	private PessoaVo getPessoaPorCpf(PessoaVo pessoaVo) {
		return pessoaVo;
	}
}
