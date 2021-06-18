package visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

import NCLog.User.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class LoginPrincipal {
	
	/**
	 * Não alterar nada aqui até a linha 54.
	 */

	private JFrame frmNcLog;
	private JTextField txtUser;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPrincipal window = new LoginPrincipal();
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
	public LoginPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNcLog = new JFrame();
		frmNcLog.setForeground(Color.BLACK);
		frmNcLog.setTitle("NC LOG");
		frmNcLog.setBounds(100, 100, 450, 300);
		frmNcLog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNcLog.getContentPane().setLayout(null);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelUsuario.setBounds(118, 106, 46, 14);
		frmNcLog.getContentPane().add(labelUsuario);
		
		txtUser = new JTextField();			// Espaço para o user digitar o usuario (getText)
		txtUser.setBounds(171, 103, 86, 20);
		frmNcLog.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha");
		labelSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelSenha.setBounds(118, 137, 46, 14);
		frmNcLog.getContentPane().add(labelSenha);
		
		txtPassword = new JPasswordField(); // Espaço para o user digitar a senha (getText)
		txtPassword.setEchoChar('*');
		txtPassword.setBounds(171, 134, 86, 20);
		frmNcLog.getContentPane().add(txtPassword);
		
		JButton btLogin = new JButton("Entrar");
		btLogin.addActionListener(new ActionListener() {
			/**
			 * Ação do botão de login
			 * Colocar em baixo o metodo que verifica as credenciais
			 * e abre a tela principal
			 */
			public void actionPerformed(ActionEvent e) {
				// Acão do botão
				Usuario u = new Usuario();
				u.setNome_usuario(txtUser.getText());
				u.setSenha(new String(txtPassword.getPassword()));
				u.login();
			}
		});
		btLogin.setForeground(Color.BLACK);
		btLogin.setBounds(212, 172, 89, 23);
		frmNcLog.getContentPane().add(btLogin);
		
		JLabel lblNewLabel_1 = new JLabel("Seja bem vindo ao NC Log!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(26, 25, 377, 50);
		frmNcLog.getContentPane().add(lblNewLabel_1);
		
		JButton btRegistrar = new JButton("Registrar");
		btRegistrar.addActionListener(new ActionListener() {
			/**
			 * Ação do botão para Registrar
			 * Colocar em baixo o metodo que leve o usuario para
			 * a TelaRegistroUser.java
			 */
			public void actionPerformed(ActionEvent e) {
				// Acão do botão
			}
		});
		btRegistrar.setForeground(Color.BLACK);
		btRegistrar.setBounds(106, 172, 89, 23);
		frmNcLog.getContentPane().add(btRegistrar);
		
		JLabel txtUserError = new JLabel("");   // Serve para aparecer mensagem de erro quando o usuario errar o usuario (CONFIGURAR AINDA)
		txtUserError.setForeground(Color.RED);
		txtUserError.setBounds(274, 106, 46, 14);
		frmNcLog.getContentPane().add(txtUserError);
		
		JLabel txtPasswordError = new JLabel(""); // Serve para aparecer mensagem de erro quando o usuario errar a senha (CONFIGURAR AINDA)
		txtPasswordError.setForeground(Color.RED);
		txtPasswordError.setBounds(274, 137, 46, 14);
		frmNcLog.getContentPane().add(txtPasswordError);
	}
}
