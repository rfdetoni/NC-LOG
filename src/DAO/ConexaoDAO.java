package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConexaoDAO {
	public Connection conectaDB() {
		
		Connection conn = null;
		
		try {
			/*String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);*/
			String url = "jdbc:mysql://remotemysql.com:3306/DFhXw9CErT?user=DFhXw9CErT&password=iOniTlgZv3";
			conn = DriverManager.getConnection(url);
			
		} catch (Exception erro) {
			JOptionPane.showInternalMessageDialog(null,"Conexão DAO" + erro.getMessage());
		}
		return conn;
	}

}
