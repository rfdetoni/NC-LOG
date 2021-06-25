package DTO;

public class VariaveisEstaticas {
	
	private static int id_nc, id_plano;
	private static String usuario_logado, responsavel, nome_nc, local;
	
	
	
	
	
	
	
	public  String getResponsavel() {
		return responsavel;
	}
	public  void setResponsavel(String responsavel) {
		VariaveisEstaticas.responsavel = responsavel;
	}
	public  String getNome_nc() {
		return nome_nc;
	}
	public  void setNome_nc(String nome_nc) {
		VariaveisEstaticas.nome_nc = nome_nc;
	}
	public  String getLocal() {
		return local;
	}
	public  void setLocal(String local) {
		VariaveisEstaticas.local = local;
	}
	public  int getId_nc() {
		return id_nc;
	}
	public  void setId_nc(int id_nc) {
		VariaveisEstaticas.id_nc = id_nc;
	}
	public  int getId_plano() {
		return id_plano;
	}
	public  void setId_plano(int id_plano) {
		VariaveisEstaticas.id_plano = id_plano;
	}
	public  String getUsuario_logado() {
		return usuario_logado;
	}
	public  void setUsuario_logado(String usuario_logado) {
		VariaveisEstaticas.usuario_logado = usuario_logado;
	}

}
