package bdController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BdController {

	private static Connection connection = null;

	public static void connect() {
		String hostname = "pablomerinas.com";
		String database = "u331830226_users";
		String username = "u331830226_admin";
		String password = "Admin1234";

		String url = "jdbc:mysql://" + hostname + "/" + database;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			if (connection != null)
				System.out.println("Conexión exitosa");
			else {
				System.out.println("Conexión fallida");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void disconnect() {
		if (connection != null)
			try {
				connection.close();
				System.out.println("Desconxion exitosa");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}