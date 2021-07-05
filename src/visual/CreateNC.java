
package visual;

import DAO.NCDAO;
import DTO.NcDTO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class CreateNC extends javax.swing.JFrame {

	public CreateNC() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(CreateNC.class.getResource("/imagens/icon.jpg")));
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		txtNome_Nc = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtresponsavel_Nc = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtlocal_Nc = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtdescricao_Nc = new javax.swing.JTextArea();
		btnCancelar = new javax.swing.JButton();
		btnSalvar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Inserir N�o Conformidade");
		setLocationByPlatform(true);

		jLabel1.setText("T�tulo da N�o conformidade:");

		jLabel2.setText("Respons�vel:");

		jLabel3.setText("Local onde ocorreu:");

		txtlocal_Nc.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				txtlocal_NcActionPerformed(evt);
			}
		});

		jLabel4.setText("Descri��o da NC");

		txtdescricao_Nc.setColumns(20);
		txtdescricao_Nc.setRows(5);
		txtdescricao_Nc.setLineWrap(true);
		jScrollPane1.setViewportView(txtdescricao_Nc);

		btnCancelar.setText("Cancelar");
		btnCancelar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelarActionPerformed(evt);
			}
		});

		btnSalvar.setText("Salvar");
		btnSalvar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSalvarActionPerformed(evt);
			}
		});

		lblNewLabel = new JLabel("Status");

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Aberto", "Conclu\u00EDdo", "Em Execu\u00E7\u00E3o", "Cancelado" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(154)
					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(146)
					.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
					.addGap(137))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(216, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtresponsavel_Nc, 201, 201, 201)
						.addComponent(txtNome_Nc, 201, 201, 201))
					.addGap(189))
				.addGroup(layout.createSequentialGroup()
					.addGap(252)
					.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
					.addGap(246))
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGap(167)
							.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtlocal_Nc, 201, 201, 201)))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(94)
							.addComponent(lblNewLabel))
						.addGroup(layout.createSequentialGroup()
							.addGap(66)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(144))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(253, Short.MAX_VALUE)
					.addComponent(jLabel1)
					.addGap(218))
				.addGroup(layout.createSequentialGroup()
					.addGap(273)
					.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
					.addGap(236))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(26)
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtresponsavel_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel3)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtlocal_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(jLabel4)
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addGap(52))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void txtlocal_NcActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {

		dispose();
	}

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) { // bot�o salvar;
		NcDTO objnc = new NcDTO();
		String nome_nc, responsavel, local, descricao;
		nome_nc = txtNome_Nc.getText();
		responsavel = txtresponsavel_Nc.getText();
		local =txtlocal_Nc.getText();
		descricao = txtdescricao_Nc.getText();
		if(nome_nc.equals("")) {
			JOptionPane.showMessageDialog(null,"Campo Titulo da NC n�o pode estar vazio", "AVISO",JOptionPane.WARNING_MESSAGE);
		}else if(responsavel.equals("")){
			JOptionPane.showMessageDialog(null,"Campo Respons�vel n�o pode estar vazio", "AVISO",JOptionPane.WARNING_MESSAGE);
		}else if(local.equals("")){
			JOptionPane.showMessageDialog(null,"Campo Local n�o pode estar vazio", "AVISO",JOptionPane.WARNING_MESSAGE);
		}else if(descricao.equals("")){
			JOptionPane.showMessageDialog(null,"Campo Descri��o n�o pode estar vazio", "AVISO",JOptionPane.WARNING_MESSAGE);
		}else {
		
		

		objnc.setNome_Nc(nome_nc);

		objnc.setResponsavel_Nc(responsavel);
		objnc.setLocal_Nc(local);
		objnc.setDescricao_Nc(descricao);
		objnc.setStatus(comboBox.getSelectedItem().toString());

		NCDAO objncdao = new NCDAO();

		objncdao.registerNC(objnc);

		
		
		descricao = txtdescricao_Nc.getText();
		objncdao.PegarID(nome_nc, descricao);
		dispose();
		}
	}

	public void setTxtNome(String txtNome) {
		txtNome_Nc.setText(txtNome);
	}

	public void setTxtResponsavelNc(String resp) {
		txtresponsavel_Nc.setText(resp);
	}

	public void setLocalNC(String local) {
		txtlocal_Nc.setText(local);
	}

	public void setDescricao(String descricao) {
		txtdescricao_Nc.setText(descricao);
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
			java.util.logging.Logger.getLogger(CreateNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(CreateNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(CreateNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(CreateNC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new CreateNC().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCancelar;
	private javax.swing.JButton btnSalvar;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField txtNome_Nc;
	private javax.swing.JTextArea txtdescricao_Nc;
	private javax.swing.JTextField txtlocal_Nc;
	private javax.swing.JTextField txtresponsavel_Nc;
	private JLabel lblNewLabel;
	private JComboBox<String> comboBox;
	// End of variables declaration
}
