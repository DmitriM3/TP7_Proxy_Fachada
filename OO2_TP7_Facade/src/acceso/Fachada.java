package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import modelo.DBFacade;

public class Fachada implements DBFacade {

	Connection conn;

	@Override
	public void open() {
		String url = "jdbc:mysql://localhost:3306/oo2_ejercicios";
		String user = "root";
		String pass = "";
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			throw new RuntimeException("No se pudo abrir la conexion", e);
		}

	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {
		List<Map<String, String>> miLista = null;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return miLista;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al cerrar la conexion", e);
		}

	}

}
