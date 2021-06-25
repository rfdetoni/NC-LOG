package DTO;

public class NcDTO {
	private String nome_Nc, descricao_Nc, local_Nc, responsavel_Nc, status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private int id_Nc, id_Plano;
	
	
	public String getNome_Nc() {
		return nome_Nc;
	}
	public void setNome_Nc(String nome_N) {
		this.nome_Nc = nome_N;
	}
	public String getDescricao_Nc() {
		return descricao_Nc;
	}
	public void setDescricao_Nc(String descricao_Nc) {
		this.descricao_Nc = descricao_Nc;
	}
	public String getLocal_Nc() {
		return local_Nc;
	}
	public void setLocal_Nc(String local_Nc) {
		this.local_Nc = local_Nc;
	}
	public String getResponsavel_Nc() {
		return responsavel_Nc;
	}
	public void setResponsavel_Nc(String responsavel_Nc) {
		this.responsavel_Nc = responsavel_Nc;
	}
	public int getId_Nc() {
		return id_Nc;
	}
	public void setId_Nc(int id_Nc) {
		this.id_Nc = id_Nc;
	}
	public int getId_Plano() {
		return id_Plano;
	}
	public void setId_Plano(int id_Plano) {
		this.id_Plano = id_Plano;
	}
	
	

}
