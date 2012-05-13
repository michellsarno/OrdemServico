package br.com.dao.ordemservico;

public class BaseDao {


	public void validaQuantidadeParametros(StringBuilder qry, int i) throws Exception {
		
		int length = qry.toString().replaceAll("[^?]*", "").length();
		
		if(length != --i){
			throw new Exception("Numero parametros na query: "+length+" - "+"informado: "+i);
		}
	}
	
	public String getValues(StringBuilder qry) throws Exception {

		int abertura;
		int fechamento;
		
		String busca = qry.toString();
		
		abertura = busca.indexOf("(");
		fechamento = busca.indexOf(")");
		
		if(abertura == -1 || fechamento == -1){
			throw new Exception("Falta algum parentese na query");
		}
		
		busca = busca.substring(abertura, fechamento+1);
		
		abertura = busca.replaceAll("[^(]*", "").length();
		fechamento = busca.replaceAll("[^)]*", "").length();
		
		if(abertura != 1  || fechamento != 1){
			throw new Exception("Verifique os colcehetes de abertura e fechamento da query ( )");
		}
		
		busca = busca.replaceAll("[^,()]*"," ").replaceAll("  ", " ?");
		
		busca = "values".concat(busca);

		return busca;
	}
}
