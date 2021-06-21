package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.PlanoDTO;
import visual.okNext;

public class PlanoDAO {
	Connection conn;
	PreparedStatement pstm;

	public void registerPlan(PlanoDTO objplano) {

		String sql = "insert into planoDeAcao (nome_Criador,estrategia,time_resp) values (?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objplano.getNome_Criador());
			pstm.setString(2, objplano.getEstrategia());
			pstm.setString(3, objplano.getTime_resp());

			pstm.execute();
			pstm.close();
			JOptionPane.showMessageDialog(null, "Plano de ação cadastrado");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO " + erro);
		}

	}

}
