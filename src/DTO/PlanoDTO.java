package DTO;

import java.util.Date;

public class PlanoDTO {
private String nome_Criador, estrategia, exec_plano, time_resp;

public String getNome_Criador() {
	return nome_Criador;
}

public void setNome_Criador(String nome_Criador) {
	this.nome_Criador = nome_Criador;
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
	Date data = new Date();
	this.exec_plano = data.toString();
	System.out.print(this.exec_plano);
}

public String getTime_resp() {
	return time_resp;
}

public void setTime_resp(String time_resp) {
	this.time_resp = time_resp;
}


}
