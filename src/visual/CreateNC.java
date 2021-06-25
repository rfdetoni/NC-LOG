
package visual;

import DAO.NCDAO;
import DTO.NcDTO;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class CreateNC extends javax.swing.JFrame {

	public CreateNC() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
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

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(154)
					.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(146)
					.addComponent(btnSalvar, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addGap(137))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
					.addGap(6))
				.addGroup(layout.createSequentialGroup()
					.addGap(220)
					.addComponent(jLabel1)
					.addContainerGap(221, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(186, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtlocal_Nc, 201, 201, 201)
						.addComponent(txtresponsavel_Nc, 201, 201, 201)
						.addComponent(txtNome_Nc, 201, 201, 201))
					.addGap(189))
				.addGroup(layout.createSequentialGroup()
					.addGap(255)
					.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
					.addGap(254))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(242)
					.addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
					.addGap(238))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(252)
					.addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(246))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(26)
					.addComponent(jLabel1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtresponsavel_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabel3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtlocal_Nc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
	}// </editor-fold>

	private void txtlocal_NcActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {
		Home home = new Home();
		home.setVisible(true);
		dispose();
	}

	private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) { // bot�o salvar;
		NcDTO objnc = new NcDTO();
		objnc.setNome_Nc(txtNome_Nc.getText());
		objnc.setResponsavel_Nc(txtresponsavel_Nc.getText());
		objnc.setLocal_Nc(txtlocal_Nc.getText());
		objnc.setDescricao_Nc(txtdescricao_Nc.getText());

		NCDAO objncdao = new NCDAO();

		objncdao.registerNC(objnc);
		
		String nome, descricao;
		nome = txtNome_Nc.getText();
		descricao = txtdescricao_Nc.getText();
		objncdao.PegarID(nome, descricao);
		dispose();

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
	// End of variables declaration
}
