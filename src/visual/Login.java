package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.NCDAO;
import DAO.PlanoDAO;

//import com.sun.tools.javap.TryBlockWriter;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import DTO.VariaveisEstaticas;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtGetUsername;
	private JPasswordField txtGetPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Login frame = new Login();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});	
	}

	/**rrod
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagens/icon.jpg")));
		setTitle("Bem vindo ao NCLOG");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNcLogWelcome = new JLabel("Seja bem vindo ao NC Log!");
		lblNcLogWelcome.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNcLogWelcome.setBounds(26, 31, 377, 50);
		contentPane.add(lblNcLogWelcome);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(131, 126, 46, 14);
		contentPane.add(lblUser);
		
		txtGetUsername = new JTextField(); // Espaço para o user digitar o usuario (getText)
		txtGetUsername.setColumns(10);
		txtGetUsername.setBounds(184, 123, 86, 20);
		contentPane.add(txtGetUsername);
		
		JLabel lblPassword = new JLabel("Senha");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(131, 157, 46, 14);
		contentPane.add(lblPassword);

		txtGetPassword = new JPasswordField();// Espaço para o user digitar a senha (getText)
		txtGetPassword.setEchoChar('*');
		txtGetPassword.setBounds(184, 154, 86, 20);
		contentPane.add(txtGetPassword);
		
		JButton btRegistrar = new JButton("Registrar");
		
		btRegistrar.addActionListener(new ActionListener() {
			/**
			 * Ação do botão para Registrar
			 * Colocar em baixo o metodo que leve o usuario para
			 * a TelaRegistroUser.java
			 */
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegisterScreen rgts = new RegisterScreen();
				rgts.setVisible(true);
			}
		});
		btRegistrar.setForeground(Color.BLACK);
		btRegistrar.setBounds(119, 192, 89, 23);
		contentPane.add(btRegistrar);

		JButton btLogin = new JButton("Entrar");
		btLogin.addActionListener(new ActionListener() {
			/**
			 * Ação do botão de login
			 * Colocar em baixo o metodo que verifica as credenciais
			 * e abre a tela principal
			 */
			public void actionPerformed(ActionEvent e) {
				try{
					UsuarioDTO objuser = new UsuarioDTO();
					String passText = new String(txtGetPassword.getPassword());
					String user = (txtGetUsername.getText());
					objuser.setNome_User(user);
					
					objuser.setSenha(passText);
					
					UsuarioDAO objuserDAO = new UsuarioDAO();
					ResultSet rsuserdao = objuserDAO.autUsuario(objuser);
					NCDAO ndao = new NCDAO();
					ndao.setRespNc(user);
					PlanoDAO plano = new PlanoDAO();
					plano.setRespNc(user);
					
					
					VariaveisEstaticas ve = new VariaveisEstaticas();
					ve.setUsuario_logado(user);
					
					if(rsuserdao.next()) {
						VariaveisEstaticas.id_user = (rsuserdao.getInt("id_User"));
							//JOptionPane.showMessageDialog(null, "Bem vindo! " +user );
						
						Home homenc = new Home();
						homenc.setUser(user);
						homenc.setVisible(true);
						
						UsuarioDAO udao = new UsuarioDAO();
						udao.setUserOn(user);
						
						
						dispose();
						
					}else {
						//enviar mensagem de erro;
						JOptionPane.showMessageDialog(null, "Usuario ou senha invalidos");
					}
				} catch(SQLException erro) {
					JOptionPane.showMessageDialog(null,"mainScreen login" + erro);
				}
			}
		});

		btLogin.setForeground(Color.BLACK);
		btLogin.setBounds(225, 192, 89, 23);
		contentPane.add(btLogin);
		getRootPane().setDefaultButton(btLogin);

		JLabel txtUserError = new JLabel(""); // Serve para aparecer mensagem de erro quando o usuario errar o usuario (CONFIGURAR AINDA)
		txtUserError.setForeground(Color.RED);
		txtUserError.setBounds(280, 126, 46, 14);
		contentPane.add(txtUserError);
		
		JLabel txtPasswordError = new JLabel(""); // Serve para aparecer mensagem de erro quando o usuario errar o usuario (CONFIGURAR AINDA)
		txtPasswordError.setForeground(Color.RED);
		txtPasswordError.setBounds(280, 157, 46, 14);
		contentPane.add(txtPasswordError);
	}
}
