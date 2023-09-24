package bdController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class BdController {

	private static Connection connection = null;

	public static void connect() {
		String hostname = "pablomerinas.com";
		String database = "u331830226_users";
		String username = "u331830226_admin";
		String password = "Admin1234";

		String url = "jdbc:mysql://" + hostname + "/" + database;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
//			if (connection != null)
//				System.out.println("Conexión exitosa");
//			else {
//				System.out.println("Conexión fallida");
//			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean addUser(User user) {
		PreparedStatement preparedStatement = null;
		boolean isAdded = false;

		connect();
		try {
			String sql = "INSERT INTO users (name, subName, dni, username, password) VALUES (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getSubName());
			preparedStatement.setString(3, user.getDni());
			preparedStatement.setString(4, user.getUsername());
			preparedStatement.setString(5, user.getPassword());

			preparedStatement.executeUpdate();
			System.out.println("Usuario añadido correctamente"); // Lo uso para comprobar
			isAdded = true;
		} catch (SQLException e) {
			e.printStackTrace();

		}
		disconnect();

		return isAdded;
	}

	public static List<User> getUserList() {
		List<User> userList = new ArrayList<>();

		connect();
		try {
			String sql = "SELECT * FROM users"; // Consulta SQL para seleccionar todos los usuarios
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// Obtener datos de cada fila del resultado y crear objetos User
				String name = resultSet.getString("name");
				String subName = resultSet.getString("subName");
				String dni = resultSet.getString("dni");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");

				User user = new User(name, subName, dni, username, password);
				userList.add(user);
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return userList;
	}

	public static boolean deleteUser(String dni) {
		boolean isDeleted = false;

		connect();
		try {
			String sql = "DELETE FROM users WHERE dni = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);

			int rowsDeleted = preparedStatement.executeUpdate();

			if (rowsDeleted > 0) {
				isDeleted = true;
			}

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return isDeleted;
	}

	public static boolean modifyUser(String dniPreUser, User newUser) {
		boolean isModified = false;

		connect();
		try {
			String sql = "UPDATE users SET name = ?, subName = ?,dni = ?, username = ?, password = ? WHERE dni = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, newUser.getName());
			preparedStatement.setString(2, newUser.getSubName());
			preparedStatement.setString(3, newUser.getDni());
			preparedStatement.setString(4, newUser.getUsername());
			preparedStatement.setString(5, newUser.getPassword());
			preparedStatement.setString(6, dniPreUser);

			int rowsUpdated = preparedStatement.executeUpdate();

			if (rowsUpdated > 0) {
				isModified = true;
			}

			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return isModified;
	}

	public static User getUser(String dni) {
		User user = null;

		connect();
		try {
			String sql = "SELECT * FROM users WHERE dni = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dni);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				user = new User();
				user.setDni(resultSet.getString("dni"));
				user.setName(resultSet.getString("name"));
				user.setSubName(resultSet.getString("subName"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}

			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();

		return user;
	}

	public static void disconnect() {
		if (connection != null)
			try {
				connection.close();
//				System.out.println("Desconxion exitosa");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}