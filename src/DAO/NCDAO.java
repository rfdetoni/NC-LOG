package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DTO.NcDTO;

public class NCDAO {
	Connection conn;
	PreparedStatement pstm;

	public void registerNC(NcDTO objnc) {

		String sql = "insert into naoConformidade (nome_Nc,descricao_Nc,local_Nc,responsavel_Nc) values (?,?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objnc.getNome_Nc());
			pstm.setString(2, objnc.getDescricao_Nc());
			pstm.setString(3, objnc.getLocal_Nc());
			pstm.setString(4, objnc.getResponsavel_Nc());
			
			pstm.execute();
			pstm.close();
			JOptionPane.showMessageDialog(null, "NC cadastrada com sucesso!");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO " + erro);
		}

	}

}
