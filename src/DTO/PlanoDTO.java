package DTO;


public class PlanoDTO {
private String nome_Criador, estrategia, exec_plano, time_resp, nome_Plano	;
private int id_Nc, id_Plano;

public String getNome_Criador() {
	return nome_Criador;
}

public void setNome_Criador(String nome_Criador) {
	this.nome_Criador = nome_Criador;
}

public String getNome_Plano() {
	return nome_Plano;
}

public void setNome_Plano(String nome_Plano) {
	this.nome_Plano = nome_Plano;
}

public String getEstrategia() {
	return estrategia;
}

public void setEstrategia(String estrategia) {
	this.estrategia = estrategia;
}

public String getExec_plano() {
	return exec_plano;
}

public void setExec_plano(String exec_plano) {
	
	this.exec_plano =exec_plano;
	
}

public String getTime_resp() {
	return time_resp;
}

public void setTime_resp(String time_resp) {
	this.time_resp = time_resp;
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
