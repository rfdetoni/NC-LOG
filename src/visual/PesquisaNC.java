
package visual;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import DAO.NCDAO;
import DAO.PlanoDAO;
import DTO.NcDTO;
import DTO.VariaveisEstaticas;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class PesquisaNC extends javax.swing.JFrame {

	private static String nome_NC, local_NC, responsavel_NC;
	private static int id_NC, id_Plano;

	public String getNome_NC() {
		return nome_NC;
	}

	public void setNome_NC(String nome_NC) {
		this.nome_NC = nome_NC;
	}

	public String getLocal_NC() {
		return local_NC;
	}

	public void setLocal_NC(String local_NC) {
		this.local_NC = local_NC;
	}

	public String getResponsavel_NC() {
		return responsavel_NC;
	}

	public void setResponsavel_NC(String responsavel_NC) {
		this.responsavel_NC = responsavel_NC;
	}

	public int getId_NC() {
		return id_NC;
	}

	public void setId_NC(int id_NC) {
		this.id_NC = id_NC;
	}

	public int getId_Plano() {
		return id_Plano;
	}

	public void setId_Plano(int id_Plano) {
		this.id_Plano = id_Plano;
	}

	public PesquisaNC() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PesquisaNC.class.getResource("/imagens/icon.jpg")));
		setTitle("Pesquisar/Edtiar NC");
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtPesquisa = new javax.swing.JTextField();
		scrollPesquisa = new javax.swing.JScrollPane();
		tblPesquisa = new javax.swing.JTable();
		btnPesquisarNC = new javax.swing.JButton();
		btnOpen = new javax.swing.JButton();
		btnOpen.setToolTipText("Visualizar ou editar NC selecionada");

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Pesquisa por nome da NC:");

		tblPesquisa.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "ID NC", "Nome ", "Respons\u00E1vel", "ID plano de a\u00E7\u00E3o",
						"Descri\u00E7\u00E3o", "Local", "Status" }));
		tblPesquisa.setColumnSelectionAllowed(true);
		scrollPesquisa.setViewportView(tblPesquisa);

		btnPesquisarNC.setText("pesquisar");
		btnPesquisarNC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPesquisarNCActionPerformed(evt);
			}
		});

		btnOpen.setText("Visualizar/editar");
		btnOpen.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnOpenActionPerformed(evt);
			}
		});

		JLabel lblNewLabel = new JLabel("Nome da NC:");

		txtNomeNC = new JTextField();
		txtNomeNC.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Respons\u00E1vel:");

		txtResponsavel = new JTextField();
		txtResponsavel.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Local:");

		txtLocal = new JTextField();
		txtLocal.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("ID da NC");

		txtIdNC = new JTextField();
		txtIdNC.setEditable(false);
		txtIdNC.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("ID Plano de A\u00E7\u00E3o");

		txtPlano = new JTextField();
		txtPlano.setEditable(false);
		txtPlano.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Descri\u00E7\u00E3o");

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalvarEdit();
			}
		});

		JSeparator separator = new JSeparator();

		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		txtDesc = new JTextArea();
		txtDesc.setLineWrap(true);

		JLabel lblNewLabel_6 = new JLabel("Status");

		comboStatus = new JComboBox();
		
		comboStatus.setModel(new DefaultComboBoxModel(
				new String[] { "Aberto", "Conclu\u00EDdo", "Em Execu\u00E7\u00E3o", "Cancelada" }));

		lblCancelado = new JLabel("");
		lblCancelado.setForeground(Color.RED);
		lblCancelado.setFont(new Font("Tahoma", Font.BOLD, 13));

		JButton btnPlano = new JButton("Criar plano de a\u00E7\u00E3o");
		btnPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				criar();

			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(separator, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(333, Short.MAX_VALUE)
					.addComponent(btnVoltar)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPlano)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton)
					.addGap(40))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(37)
					.addComponent(lblCancelado)
					.addPreferredGap(ComponentPlacement.RELATED, 486, Short.MAX_VALUE)
					.addComponent(btnOpen)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPesquisa, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(jLabel1)
							.addGap(18)
							.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnPesquisarNC)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, 622, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addGap(12)
							.addComponent(txtIdNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeNC, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(0)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_6)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboStatus, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(280))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(295)
					.addComponent(lblNewLabel_5)
					.addContainerGap(301, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel1)
						.addComponent(txtPesquisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPesquisarNC))
					.addGap(20)
					.addComponent(scrollPesquisa, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnOpen)
							.addGap(11))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCancelado)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtIdNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtPlano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6)
						.addComponent(comboStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(lblNewLabel_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtNomeNC, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addComponent(txtResponsavel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)
								.addComponent(txtLocal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(8)
					.addComponent(txtDesc, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnPlano)
						.addComponent(btnVoltar))
					.addGap(12))
		);
		getContentPane().setLayout(groupLayout);

		pack();
	}// </editor-fold>

	private void btnPesquisarNCActionPerformed(java.awt.event.ActionEvent evt) {
		resPesquisa();
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PesquisaNC.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PesquisaNC().setVisible(true);
			}
		});
	}

	public void resPesquisa() {
		try {
			NCDAO objNCDAO = new NCDAO();
			String pesquisa = txtPesquisa.getText();

			DefaultTableModel model = (DefaultTableModel) tblPesquisa.getModel();
			model.setNumRows(0);

			ArrayList<NcDTO> lista = objNCDAO.PesquisaNC(pesquisa);
			for (int num = 0; num < lista.size(); num++) {

				model.addRow(new Object[] { lista.get(num).getId_Nc(), lista.get(num).getNome_Nc(),
						lista.get(num).getResponsavel_Nc(), lista.get(num).getId_Plano(),
						lista.get(num).getDescricao_Nc(), lista.get(num).getLocal_Nc(), lista.get(num).getStatus()

				});

			}

		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "Informe ao desenvolvedor >PesquisarNC resPesquisa ","ERRO", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
		Load();
		Carregar();

	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnOpen;
	private javax.swing.JButton btnPesquisarNC;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane scrollPesquisa;
	private javax.swing.JTable tblPesquisa;
	private javax.swing.JTextField txtPesquisa;
	private JTextField txtNomeNC;
	private JTextField txtResponsavel;
	private JTextField txtLocal;
	private JTextField txtIdNC;
	private JTextField txtPlano;
	private JButton btnVoltar;
	private JTextArea txtDesc;
	private JComboBox comboStatus;
	private JLabel lblCancelado;

	// carrega dados da planilha para campo de edi??o;
	private void Carregar() {
		try {
			int setar = tblPesquisa.getSelectedRow();
			
			PlanoDAO plano = new PlanoDAO();
			plano.PegarIdPLano(txtIdNC.getText());
			String combo = tblPesquisa.getModel().getValueAt(setar, 6).toString();
			String idplano = tblPesquisa.getModel().getValueAt(setar, 3).toString();
			if(combo.equals("Aberto") && idplano.equals("0")) {
				comboStatus.setEnabled(false);
				comboStatus.setToolTipText("Para alterar o status \u00E9 necess\u00E1rio a cria\u00E7\u00E3o de um plano de a\u00E7\u00E3o, inclusive para descrever o motivo do cancelamento do plano.");
								
			}
			
			txtIdNC.setText(tblPesquisa.getModel().getValueAt(setar, 0).toString());
			txtPlano.setText(idplano);
		
			txtLocal.setText(tblPesquisa.getModel().getValueAt(setar, 5).toString());
			txtNomeNC.setText(tblPesquisa.getModel().getValueAt(setar, 1).toString());
			txtResponsavel.setText(tblPesquisa.getModel().getValueAt(setar, 2).toString());
			txtDesc.setText(tblPesquisa.getModel().getValueAt(setar, 4).toString());
			comboStatus.setSelectedItem(combo);

			Bloqueio();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Favor selecionar uma linha para visualizar ou editar");

		}

	}

	private void SalvarEdit() {
		int id_NC, id_Plano;
		NCDAO objncdao = new NCDAO();
		NcDTO objncDTO = new NcDTO();

		String nome_Nc, responsavel_nc, local, descricao, status;

		id_NC = Integer.parseInt(txtIdNC.getText());
		nome_Nc = txtNomeNC.getText();
		responsavel_nc = txtResponsavel.getText();
		local = txtLocal.getText();
		descricao = txtDesc.getText();
		status = comboStatus.getSelectedItem().toString();
		id_Plano = Integer.parseInt(txtPlano.getText());
		
	
		objncDTO.setId_Nc(id_NC);
		objncDTO.setDescricao_Nc(descricao);
		objncDTO.setLocal_Nc(local);
		objncDTO.setNome_Nc(nome_Nc);
		objncDTO.setResponsavel_Nc(responsavel_nc);
		objncDTO.setStatus(status);
		objncDTO.setId_Plano(id_Plano);
		// valida se h? plano de a??o listado na tela de edi??o, se n?o houver,
		// disponibiliza a janela de op??o para criar.
		String id_plano = txtPlano.getText();
		if ("0".equals(id_plano)) {
			objncdao.PegarID(nome_Nc, descricao);
			okNext ok = new okNext();
			ok.setVisible(true);
		} // fim valida??o

		objncdao.EditarNC(objncDTO);
		resPesquisa();
		Bloqueio();

	}

	private void Load() {
		VariaveisEstaticas ve = new VariaveisEstaticas();
		txtPlano.setText(Integer.toString(ve.getId_plano()));

	}

	private void Bloqueio() { // bloqueia campos caso NC esteja cancelada
		if (comboStatus.getSelectedItem() == "Cancelada") {
			txtDesc.setEditable(false);
			txtLocal.setEditable(false);
			txtNomeNC.setEditable(false);
			txtResponsavel.setEditable(false);
			JOptionPane.showMessageDialog(null, "Para editar NC com Status cancelado, favor alterar o STATUS para Aberto ou Em Execu??o.", "AVISO", JOptionPane.WARNING_MESSAGE); 
			
			
			lblCancelado.setText("NC CANCELADA");

		} else {
			lblCancelado.setText("");
		}

	}

	private void criar() { // valida se h? plano de a??o para a NC selecionada, se n?o tiver, permite criar
							// uma.
		String plano = txtPlano.getText();
		if (plano.equals("0")) {
			CreatePlanodeAcao create = new CreatePlanodeAcao();
			NcDTO objncDTO = new NcDTO();

			objncDTO.setId_Nc(Integer.parseInt(txtIdNC.getText()));
			objncDTO.setLocal_Nc(txtLocal.getText());
			objncDTO.setNome_Nc(txtNomeNC.getText());
			objncDTO.setResponsavel_Nc(txtResponsavel.getText());

			create.dados(objncDTO);
			create.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, "NC j? possui plano de a??o");

		}

	}
}
