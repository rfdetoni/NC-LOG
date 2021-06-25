package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.PlanoDTO;
import DTO.VariaveisEstaticas;
import visual.okNext;

public class PlanoDAO {
	Connection conn;
	PreparedStatement pstm;
	private static String resp_nc;
	ResultSet rs;
	ArrayList<PlanoDTO> lista = new ArrayList<>();
	ArrayList<PlanoDTO> resultado = new ArrayList<>();
	ArrayList<VariaveisEstaticas> idplano = new ArrayList<>();
	
	public void setRespNc(String resp_nc) {
		this.resp_nc = resp_nc;

	}

	public String getRespNc() {
		return resp_nc;
	}

	public void registerPlan(PlanoDTO objplano) {

		String sql = "insert into planoDeAcao (nome_Plano,nome_Criador,estrategia,time_resp,id_Nc) values (?,?,?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objplano.getNome_Plano());
			pstm.setString(2, objplano.getNome_Criador());
			pstm.setString(3, objplano.getEstrategia());
			pstm.setString(4, objplano.getTime_resp());
			pstm.setInt(5, objplano.getId_Nc());

			pstm.execute();
			pstm.close();
			JOptionPane.showMessageDialog(null, "Plano de ação cadastrado");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO " + erro);
		}

	}
	
	public ArrayList<PlanoDTO> PesquisaPlano(String Pesquisa) {

		String sql = "select * from planoDeAcao where nome_Criador = " + "'" + resp_nc + "'"
				+ " and estrategia like " + "'%" + Pesquisa + "%'";
		conn = new ConexaoDAO().conectaDB();
		
	//	JOptionPane.showMessageDialog(null,"DEBUG pesquisaPLano"+ sql);

		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				PlanoDTO objPlanoDTO = new PlanoDTO();
				
				objPlanoDTO.setId_Plano(rs.getInt("id_Plano"));
				objPlanoDTO.setTime_resp(rs.getString("time_resp"));
				objPlanoDTO.setNome_Criador(rs.getString("nome_Criador"));
				objPlanoDTO.setEstrategia(rs.getString("estrategia"));
				objPlanoDTO.setExec_plano(rs.getString("exec_Plano"));

				resultado.add(objPlanoDTO);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, " NCDAO PesquisaNC " + erro);
		}
		return resultado;

	}
	
	
	public ArrayList<VariaveisEstaticas> PegarIdPLano(String Pesquisa) {

		String sql = "select * from planoDeAcao where id_Nc = " + "'" + Pesquisa + "'";
		conn = new ConexaoDAO().conectaDB();
		
	JOptionPane.showMessageDialog(null,"DEBUG pesquisaPLano"+ sql);

		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
		VariaveisEstaticas ve = new VariaveisEstaticas();
				
				ve.setId_plano(rs.getInt("id_Plano"));
				
				idplano.add(ve);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, " PlanoDAO PegarIDPLano " + erro);
		}
		return idplano;

	}
	
	

}
