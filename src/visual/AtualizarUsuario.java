package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.ConexaoDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AtualizarUsuario extends JFrame {


	private JPanel contentPane;
	private JTextField txtSetUserRegister;
	private JPasswordField txtSetUserPassword;
	private JTextField txtSetPasswordTip;
	private JTextField txtNomeCompleto;
	private JTextField txtEmail;
	private JTextField txtIDUser;

	ResultSet rs;

	Connection conn;
	PreparedStatement pstm;

	private String iduser, email, nomecompleto, pass, tip, user;
	public static String userOn;
	private JTable tblUsuario;

	public String getUserOn() {
		return userOn;
	}

	public void setUserOn(String userOn) {
		UsuarioDAO.userOn = userOn;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizarUsuario frame = new AtualizarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtualizarUsuario() {
		// busca os dados do usuário logado;
		Carregar();

		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AtualizarUsuario.class.getResource("/imagens/icon.jpg")));
		setTitle("NC LOG - Atualizar informa\u00E7\u00F5es");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 409);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegistreSe = new JLabel("Atualizar informa\u00E7\u00F5es");
		lblRegistreSe.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblRegistreSe.setBounds(46, 17, 373, 38);
		contentPane.add(lblRegistreSe);

		JLabel lblRegisterUser = new JLabel("Usuario");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisterUser.setBounds(124, 209, 46, 14);
		contentPane.add(lblRegisterUser);

		txtSetUserRegister = new JTextField(); // Espaço para o user digitar o usuario (getText)
		txtSetUserRegister.setColumns(10);
		txtSetUserRegister.setBounds(180, 206, 128, 20);
		contentPane.add(txtSetUserRegister);

		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(133, 293, 46, 14);
		contentPane.add(lblPassword);

		txtSetUserPassword = new JPasswordField(); // Espaço para o user digitar a senha (getText)
		txtSetUserPassword.setEchoChar('*');
		txtSetUserPassword.setBounds(180, 290, 86, 20);
		contentPane.add(txtSetUserPassword);

		JButton btRegistrarUser = new JButton("Atualizar");
		btRegistrarUser.addActionListener(new ActionListener() {
			/**
			 * Ação do botão para Registrar Colocar em baixo o metodo que insera o usuario
			 * no sistema e abre a tela de LoginPincipal.java denovo.
			 */
			public void actionPerformed(ActionEvent e) {
				UsuarioDTO reg = new UsuarioDTO();
				String passText = new String(txtSetUserPassword.getPassword());

				reg.setNome_User(txtSetUserRegister.getText());
				reg.setSenha(passText);
				reg.setDica_Senha(txtSetPasswordTip.getText());
				reg.setEmail(txtEmail.getText());
				reg.setNome_Completo(txtNomeCompleto.getText());
				reg.setId_user(Integer.parseInt(txtIDUser.getText()));

				UsuarioDAO objuserdao = new UsuarioDAO();
				objuserdao.EditarUser(reg);

			}
		});
		btRegistrarUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btRegistrarUser.setBounds(237, 346, 89, 23);
		contentPane.add(btRegistrarUser);

		/**
		 * DICA DA SENHA
		 */

		JLabel lblDicaDeSenha = new JLabel("Dica de senha");
		lblDicaDeSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDicaDeSenha.setBounds(93, 318, 86, 14);
		contentPane.add(lblDicaDeSenha);

		txtSetPasswordTip = new JTextField();
		txtSetPasswordTip.setColumns(10);
		txtSetPasswordTip.setBounds(180, 315, 86, 20);
		contentPane.add(txtSetPasswordTip);

// Fim dica da senha

		JButton btCancel = new JButton("Cancelar"); // Botaão cancelar (VOLTA PARA O MainScreen)
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btCancel.setBounds(94, 346, 89, 23);
		contentPane.add(btCancel);

		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(134, 236, 36, 16);
		contentPane.add(lblNewLabel);

		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(180, 233, 128, 22);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("E-mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(132, 266, 47, 16);
		contentPane.add(lblNewLabel_1);

		txtEmail = new JTextField();
		txtEmail.setBounds(180, 263, 128, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(318, 209, 20, 14);
		contentPane.add(lblNewLabel_2);

		txtIDUser = new JTextField();
		txtIDUser.setEditable(false);
		txtIDUser.setBounds(348, 206, 71, 20);
		contentPane.add(txtIDUser);
		txtIDUser.setColumns(10);

		tblUsuario = new JTable();
		tblUsuario.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Usu\u00E1rio", "Nome completo", "email", "Dica de senha", "Senha" }));
		tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(105);
		tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblUsuario.setBounds(387, 160, -349, -91);
		contentPane.add(tblUsuario);
	}

	public void Carregar() {
		try {
			UsuarioDAO objusuarioDAO = new UsuarioDAO();
			DefaultTableModel model = (DefaultTableModel) tblUsuario.getModel();

			model.setNumRows(0);

			ArrayList<UsuarioDTO> lista = objusuarioDAO.PesquisarUsuario();
			for (int num = 0; num < lista.size(); num++) {

				model.addRow(new Object[] { lista.get(num).getNome_User(), lista.get(num).getNome_Completo(),
						lista.get(num).getEmail(), lista.get(num).getDica_Senha(), lista.get(num).getSenha()

				});

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "AtualizarUsuario - Carregar() " + e);
		}

	}
}
