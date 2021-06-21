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

	public void registerNC(PlanoDTO objplano) {

		String sql = "insert into planoDeAcao (nome_Criador,estrategia,time_resp,exec_Plano) values (?,?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objplano.getNome_Criador());
			pstm.setString(2, objplano.getEstrategia());
			pstm.setString(3, objplano.getTime_resp());
			pstm.setString(4, objplano.getExec_plano());

			pstm.execute();
			pstm.close();
			okNext ok = new okNext();
			ok.setVisible(true);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO " + erro);
		}

	}

}
