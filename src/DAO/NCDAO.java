package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NcDTO;
import DTO.UsuarioDTO;
import DTO.VariaveisEstaticas;
import visual.CreateNC;

import visual.PesquisaNC;
import visual.okNext;

public class NCDAO {
	Connection conn;
	PreparedStatement pstm;
	ResultSet rs;
	ArrayList<NcDTO> lista = new ArrayList<>();
	ArrayList<VariaveisEstaticas> lista_id = new ArrayList<>();
	ArrayList<NcDTO> resultado = new ArrayList<>();
	private static String resp_nc;
	private String pesquisa;
	private int ID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void registerNC(NcDTO objnc) {

		String sql = "insert into naoConformidade (nome_Nc,descricao_Nc,local_Nc,responsavel_Nc, status) values (?,?,?,?,?)";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objnc.getNome_Nc());
			pstm.setString(2, objnc.getDescricao_Nc());
			pstm.setString(3, objnc.getLocal_Nc());
			pstm.setString(4, objnc.getResponsavel_Nc());
			pstm.setString(5, objnc.getStatus());

			pstm.execute();
			pstm.close();
			okNext ok = new okNext();
			ok.setVisible(true);

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - registerNC " + erro);
		}

	}

	public void setRespNc(String resp_nc) {
		this.resp_nc = resp_nc;

	}

	public String getRespNc() {
		return resp_nc;
	}

	public ArrayList<NcDTO> pesquisarNC() {

		try {

			String sql = "select * from naoConformidade where responsavel_Nc = " + "'" + this.getRespNc() + "'";

			conn = new ConexaoDAO().conectaDB();

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				NcDTO objnc = new NcDTO();
				objnc.setId_Nc(rs.getInt("id_Nc"));

				objnc.setDescricao_Nc(rs.getString("descricao_Nc"));
				objnc.setLocal_Nc(rs.getString("local_Nc"));
				objnc.setNome_Nc(rs.getString("nome_Nc"));
				objnc.setResponsavel_Nc(rs.getString("responsavel_NC"));
				objnc.setId_Plano(rs.getInt("id_Plano"));
				objnc.setStatus(rs.getString("status"));

				// debug descrição
				// JOptionPane.showMessageDialog(null, objnc.getDescricao_Nc());
				lista.add(objnc);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}
		return lista;
	}

	public ArrayList<NcDTO> PesquisaNC(String Pesquisa) {

		String sql = "select * from naoConformidade where responsavel_Nc = " + "'" + resp_nc + "'"
				+ " and nome_Nc like  " + "'%" + Pesquisa + "%'" ;
		conn = new ConexaoDAO().conectaDB();

		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				NcDTO objnc = new NcDTO();
				objnc.setId_Nc(rs.getInt("id_Nc"));
				objnc.setDescricao_Nc(rs.getString("descricao_Nc"));
				objnc.setLocal_Nc(rs.getString("local_Nc"));
				objnc.setNome_Nc(rs.getString("nome_Nc"));
				objnc.setResponsavel_Nc(rs.getString("responsavel_NC"));
				objnc.setId_Plano(rs.getInt("id_Plano"));
				objnc.setStatus(rs.getString("status"));

				resultado.add(objnc);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, " NCDAO PesquisaNC " + erro);
		}
		return resultado;

	}

	//atualiza NC
	public void EditarNC(NcDTO objncDTO) {
		String sql = "update naoConformidade set nome_Nc = ?, local_Nc = ?, responsavel_Nc = ?, status = ?, descricao_Nc = ?, id_Plano = ? where id_Nc = ?";
		conn = new ConexaoDAO().conectaDB();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objncDTO.getNome_Nc());

			pstm.setString(2, objncDTO.getLocal_Nc());
			pstm.setString(3, objncDTO.getResponsavel_Nc());
			pstm.setString(4, objncDTO.getStatus());
			pstm.setString(5, objncDTO.getDescricao_Nc());
			pstm.setInt(6, objncDTO.getId_Plano());
			pstm.setInt(7, objncDTO.getId_Nc());

			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "NC atualizada");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - EditarNC " + erro);
		}

	}

	public ArrayList<VariaveisEstaticas> PegarID(String nome, String descricao) {

		try {

			String sql = "select * from naoConformidade where nome_Nc  = " + "'" + nome + "'" +" and descricao_Nc = " + "'"+ descricao +"'";

			conn = new ConexaoDAO().conectaDB();

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				VariaveisEstaticas ve =  new VariaveisEstaticas();
						ve.setId_nc(rs.getInt("id_Nc"));
						ve.setLocal(rs.getString("local_Nc"));
						ve.setNome_nc(rs.getString("nome_Nc"));
						ve.setResponsavel(rs.getString("responsavel_Nc"));
				
				// debug descrição
				// JOptionPane.showMessageDialog(null, objnc.getDescricao_Nc());
				lista_id.add(ve);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - pesquisarNC " + erro);
		}
		return lista_id;
	}
/*
	public void AtualizaIDPLANO(String ID_NC) {
		String sql = "update naoConformidade set id_Plano = ? where id_Nc = ?";
		conn = new ConexaoDAO().conectaDB();

		try {
			VariaveisEstaticas ve =  new VariaveisEstaticas();
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ve.getId_plano());
			pstm.setString(2, ID_NC);
			

			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "NC atualizada");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "NCDAO - EditarNC " + erro);
		}

	}*/
}
