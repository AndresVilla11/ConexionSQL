package datos;

import static datos.Conexion.*;
import java.sql.*;
import java.util.*;
import domain.Persona;

public class PersonaDAO {

	private Connection conexionTransaccion;
	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES(?, ?, ?, ?)";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona ?";
	private static final String SQL_INSERT_USER = "INSERT INTO persona (id_persona, nombre, apellido, email, telefono) VALUES (?, ?, ?, ?, ?)";

	public PersonaDAO() {

	}

	public PersonaDAO(Connection conexionTransaccion) {
		this.conexionTransaccion = conexionTransaccion;
	}

	public Persona seleccionarUsuario(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int idPersona = rs.getInt("id_persona");
				if (idPersona == id) {
					String nombre = rs.getString("nombre");
					String apellido = rs.getString("apellido");
					String email = rs.getString("email");
					String telefono = rs.getString("telefono");
					persona = new Persona(idPersona, nombre, apellido, email, telefono);
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return persona;
	}

	public List<Persona> seleccionar() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<>();

		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				persona = new Persona(idPersona, nombre, apellido, email, telefono);
				personas.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return personas;
	}

	public int insertar(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registrosCambios = 0;
		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			registrosCambios = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return registrosCambios;
	}

	public int insertarUsuario(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registrosCambios = 0;
		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_INSERT_USER);
			stmt.setInt(1, persona.getIdPersona());
			stmt.setString(2, persona.getNombre());
			stmt.setString(3, persona.getApellido());
			stmt.setString(4, persona.getEmail());
			stmt.setString(5, persona.getTelefono());
			registrosCambios = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return registrosCambios;
	}

	public int actualizar(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registrosCambios = 0;
		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getIdPersona());
			registrosCambios = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return registrosCambios;
	}

	public int eliminar(Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registrosCambios = 0;
		try {
			conn = this.conexionTransaccion != null ? this.conexionTransaccion : getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, persona.getIdPersona());
			registrosCambios = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			if (this.conexionTransaccion == null) {
				close(conn);
			}
		}
		return registrosCambios;
	}
}
