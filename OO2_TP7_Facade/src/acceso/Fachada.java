package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.DBFacade;

public class Fachada implements DBFacade {

	private Connection conn;

	@Override
	public void open() {
		String url = "jdbc:mysql://localhost:3306/oo2_ejercicios";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException("No se pudo abrir la conexion", e);
		}

	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {
		List<Map<String, String>> data;
		data = new ArrayList<Map<String, String>>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> datanum = new HashMap<String, String>();
				for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
					datanum.put(rsMetaData.getColumnName(i), rs.getString(i));
				}
				data.add(datanum);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return data;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {
		List<String[]> data = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsMetaData = rs.getMetaData();
			int cantColum = rsMetaData.getColumnCount();
			while (rs.next()) {
				String[] valores = new String[cantColum];
				for (int i = 0; i < cantColum; i++) {
					valores[i] = rs.getString(i + 1);
				}
				data.add(valores);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return data;
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
