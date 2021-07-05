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
	private int id_plano;
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

			
			PegarIdPLano(Integer.toString(objplano.getId_Nc()));
			
			
			JOptionPane.showMessageDialog(null, "Plano de ação cadastrado");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Informe ao Desenvolvedor > PlanoDAO registerPlan ", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public ArrayList<PlanoDTO> PesquisaPlano(String Pesquisa) {
		VariaveisEstaticas ve = new VariaveisEstaticas();
		String sql = "select * from planoDeAcao where nome_Criador = " + "'" + ve.getUsuario_logado() + "'"
				+ " and nome_Plano like " + "'%" + Pesquisa + "%'";
		conn = new ConexaoDAO().conectaDB();

		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				PlanoDTO objPlanoDTO = new PlanoDTO();

				objPlanoDTO.setId_Plano(rs.getInt("id_Plano"));
				objPlanoDTO.setTime_resp(rs.getString("time_resp"));
				objPlanoDTO.setNome_Criador(rs.getString("nome_Criador"));
				objPlanoDTO.setNome_Plano(rs.getString("nome_Plano"));
				objPlanoDTO.setEstrategia(rs.getString("estrategia"));
				objPlanoDTO.setExec_plano(rs.getString("exec_Plano"));
				objPlanoDTO.setId_Nc(rs.getInt("id_Nc"));

				resultado.add(objPlanoDTO);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Informe ao desenvolvedor > NCDAO PesquisaNC", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		return resultado;

	}

	public ArrayList<VariaveisEstaticas> PegarIdPLano(String Pesquisa) {

		String sql = "select * from planoDeAcao where id_Nc = " + "'" + Pesquisa + "'";
		conn = new ConexaoDAO().conectaDB();
		try {

			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				VariaveisEstaticas ve = new VariaveisEstaticas();
				VariaveisEstaticas.id_plano = rs.getInt("id_Plano");
				idplano.add(ve);
				NCDAO nc = new NCDAO();
				nc.inserePlano(Pesquisa, VariaveisEstaticas.id_plano);

			}

		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Informar ao desenvolvedor > PlanoDAO PegarIDPLano", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
		return idplano;

	}

	// atualiza plano de açao
	public void EditarPlano(PlanoDTO objplanoDTO) {
	

		String sql = "update planoDeAcao p inner join naoConformidade n on p.id_Nc = n.id_Nc set p.nome_Plano = ?, p.time_Resp = ?, p.nome_Criador = ?, p.estrategia = ?, p.time_resp = ?, n.id_Plano = ? where p.id_Plano = ?";
		conn = new ConexaoDAO().conectaDB();

		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, objplanoDTO.getNome_Plano());

			pstm.setString(2, objplanoDTO.getTime_resp());
			pstm.setString(3, objplanoDTO.getNome_Criador());
			pstm.setString(4, objplanoDTO.getEstrategia());
			pstm.setString(5, objplanoDTO.getTime_resp());
			pstm.setInt(6, objplanoDTO.getId_Plano());
			pstm.setInt(7, objplanoDTO.getId_Plano());

			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Plano de ação atualizado");

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Informar ao desenvolvedor > PlanoDAO - EditarPlano", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
