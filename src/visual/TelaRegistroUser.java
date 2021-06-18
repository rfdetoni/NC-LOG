package visual;

import NCLog.User.Usuario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaRegistroUser {
	/**
	 * N�o alterar nada aqui at� a linha 49
	 */

	private JFrame frmNcLog;
	private JTextField txtRegistroUser;
	private JPasswordField txtRegistoPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRegistroUser window = new TelaRegistroUser();
					window.frmNcLog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaRegistroUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNcLog = new JFrame();
		frmNcLog.setTitle("NC LOG");
		frmNcLog.setBounds(100, 100, 450, 300);
		frmNcLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNcLog.getContentPane().setLayout(null);
		
		JLabel lblRegisterUser = new JLabel("Usuario");
		lblRegisterUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRegisterUser.setBounds(127, 108, 46, 14);
		frmNcLog.getContentPane().add(lblRegisterUser);
		
		JLabel lblPasswordUser = new JLabel("Senha");
		lblPasswordUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPasswordUser.setBounds(127, 140, 46, 14);
		frmNcLog.getContentPane().add(lblPasswordUser);
		
		txtRegistroUser = new JTextField();			// Espa�o para o user digitar o usuario (getText)
		txtRegistroUser.setBounds(174, 105, 86, 20);
		frmNcLog.getContentPane().add(txtRegistroUser);
		txtRegistroUser.setColumns(10);
		
		txtRegistoPassword = new JPasswordField(); // Espa�o para o user digitar a senha (getText)
		txtRegistoPassword.setEchoChar('*');
		txtRegistoPassword.setBounds(174, 137, 86, 20);
		frmNcLog.getContentPane().add(txtRegistoPassword);
		
		JButton btRegistrarUser = new JButton("Registrar");
		btRegistrarUser.addActionListener(new ActionListener() {
			/**
			 * A��o do bot�o para Registrar
			 * Colocar em baixo o metodo que insera o usuario no sistema
			 * e abre a tela de LoginPincipal.java denovo.
			 */

			public void actionPerformed(ActionEvent e) {
				// Ac�o do bot�o
				Usuario u = new Usuario();
				u.setNome_usuario(txtRegistroUser.getText());
				u.setSenha(new String(txtRegistoPassword.getPassword()));
		
				u.cadastroUsuario();

			}
		});
		btRegistrarUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btRegistrarUser.setBounds(171, 182, 89, 23);
		frmNcLog.getContentPane().add(btRegistrarUser);
		
		JLabel lblTitleSuperior = new JLabel("Registre-se");
		lblTitleSuperior.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitleSuperior.setBounds(112, 29, 190, 38);
		frmNcLog.getContentPane().add(lblTitleSuperior);
	}

}
