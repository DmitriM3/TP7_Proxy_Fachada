package accesos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import modelo.Persona;
import modelo.Telefono;
import sujetos.TelefonosListProxy;

public class PersonaDao {

	private Connection obtenerConexion() {
		Connection conn;
		String url = "jdbc:mysql://localhost:3306/oo2_ejercicios";
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}

	public Persona personaPorId(int id) {
		String sql = "select nombre from personas where id = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonosProxy = new TelefonosListProxy(id);
			String nombrePersona = null;
			while (result.next()) {
				nombrePersona = result.getString(1);
			}
			return new Persona(id, nombrePersona, telefonosProxy);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Set<Telefono> telefonosPorId(int id) {
		String sql = "select t.numero from personas p, telefonos t where p.id = t.idpersona and p.id = ?";
		try (Connection conn = obtenerConexion(); PreparedStatement statement = conn.prepareStatement(sql);) {
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			Set<Telefono> telefonos = new HashSet<Telefono>();
			while (result.next()) {
				telefonos.add(new Telefono(result.getString(1)));
			}
			return telefonos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
