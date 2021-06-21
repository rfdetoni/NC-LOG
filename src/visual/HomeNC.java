//package visual;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JPopupMenu;
//import java.awt.Component;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JMenu;
//import javax.swing.JButton;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JLabel;
//import javax.swing.JTable;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;
//import javax.swing.JSeparator;
//import java.awt.Color;
//import javax.swing.Box;
//import java.awt.Font;
//import java.awt.Canvas;
//import javax.swing.JTabbedPane;
//import javax.swing.JTextField;
//import java.awt.SystemColor;
//import javax.swing.border.LineBorder;
//import javax.swing.JScrollPane;
//import javax.swing.JFormattedTextField;
//import javax.swing.KeyStroke;
//import java.awt.event.KeyEvent;
//import java.awt.event.InputEvent;
//
//public class HomeNC extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField txtUserSearch;
//	private JTable table;
//	private JTable table_1;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HomeNC frame = new HomeNC();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public HomeNC() {
//		setBackground(SystemColor.window);
//		setTitle("NC LOG");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 1280, 720);
//		
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
//		
//		JMenuItem mnbt_Disconnect = new JMenuItem("Sair");
//		mnbt_Disconnect.addActionListener(new ActionListener() {
//			/**
//			 * Botão para simular um Deslogamento da conta do usuario e voltar mais a MainScreen
//			 */
//			public void actionPerformed(ActionEvent e) {
//				dispose();
//				Login maincallback = new Login();
//				maincallback.setVisible(true);
//			}
//		});
//		mnbt_Disconnect.setSelected(true);
//		mnbt_Disconnect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
//		mnbt_Disconnect.setIcon(null);
//		menuBar.add(mnbt_Disconnect);
//		
//		// INICIO DE CODE INUTIL PARA VISUAL
//		JMenuItem menu_vazio = new JMenuItem("");
//		menuBar.add(menu_vazio);
//		
//		JMenuItem menu_vazio2 = new JMenuItem("");
//		menuBar.add(menu_vazio2);
//		
//		JMenuItem menu_vazio3 = new JMenuItem("");
//		menuBar.add(menu_vazio3);
//		
//		JMenuItem menu_vazio4 = new JMenuItem("");
//		menuBar.add(menu_vazio4);
//		// FIM CODE INUTIL PARA VISUAL
//		
//		contentPane = new JPanel();
//		contentPane.setBackground(SystemColor.menu);
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JButton btNcRegister = new JButton("Registrar NC"); // BOTÃO REGISTRAR NC
//		btNcRegister.setBackground(SystemColor.activeCaption);
//		btNcRegister.addActionListener(new ActionListener() {
//			/**
//			 * Botão para registrar a NC
//			 */
//			public void actionPerformed(ActionEvent e) {
//				CreateNC createnc = new CreateNC();
//				createnc.setVisible(true);
//				dispose();
//			}
//		});
//		btNcRegister.setFont(new Font("Tahoma", Font.BOLD, 13));
//		btNcRegister.setBounds(10, 551, 127, 64);
//		contentPane.add(btNcRegister);
//		
//		JLabel lblUserIdentify = new JLabel("");
//		lblUserIdentify.setForeground(Color.DARK_GRAY);
//		lblUserIdentify.setBounds(27, 628, 46, 14);
//		contentPane.add(lblUserIdentify);
//		
//		txtUserSearch = new JTextField(); // ENTRADA DE BUSCA
//		txtUserSearch.setBounds(0, 0, 1138, 29);
//		contentPane.add(txtUserSearch);
//		txtUserSearch.setColumns(10);
//		
//		JButton btSearch = new JButton("Buscar"); // BOTÃO BUSCA
//		btSearch.setBackground(SystemColor.info);
//		btSearch.addActionListener(new ActionListener() {
//			/**
//			 * Botão para pesquisa
//			 * Pegue o que o usuario digitar para filtrar
//			 */
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btSearch.setBounds(1135, 0, 129, 29);
//		contentPane.add(btSearch);
//		/**
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 * TABELA PARA NC
//		 * 
//		 * 
//		 * 
//		 * 
//		 * 
//		 */
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(1148, 28, -893, 625);
//		contentPane.add(scrollPane);
//		
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		table.setBackground(Color.GRAY);
//		
//		table_1 = new JTable();
//		table_1.setBackground(Color.GRAY);
//		table_1.setBounds(316, 312, -243, -171);
//		contentPane.add(table_1);
//		
//		// fim
//	}
//
//	private static void addPopup(Component component, final JPopupMenu popup) {
//		component.addMouseListener(new MouseAdapter() {
//			public void mousePressed(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			public void mouseReleased(MouseEvent e) {
//				if (e.isPopupTrigger()) {
//					showMenu(e);
//				}
//			}
//			private void showMenu(MouseEvent e) {
//				popup.show(e.getComponent(), e.getX(), e.getY());
//			}
//		});
//	}
//}
