package datos;

import java.util.List;
import domain.Persona;

public class AccesoDatos {
	
	public static void imprimir() {
		PersonaDAO personaDao = new PersonaDAO();
		List<Persona> persona = personaDao.seleccionar();

		for (Persona personas : persona) {
			System.out.println("Persona: " + personas);
		}
	}

	public static void imprimirUsuario(int id) {
		PersonaDAO personaDao = new PersonaDAO();
		Persona persona = personaDao.seleccionarUsuario(id);
		System.out.println("Persona: " + persona);
	}

	public static void insertar(Persona persona) {
		PersonaDAO personaDao = new PersonaDAO();
		int registroCambio = personaDao.insertar(persona);
		imprimir();
		System.out.println("Se inserto: " + registroCambio + " registros.");
	}

	public static void actualizar(Persona persona) {
		PersonaDAO personaDao = new PersonaDAO();
		int registroCambio = personaDao.actualizar(persona);
		imprimir();
		System.out.println("Se cambiaron: " + registroCambio + " registros.");
	}

	public static void eliminar(Persona persona) {
		PersonaDAO personaDao = new PersonaDAO();
		int registroCambio = personaDao.eliminar(persona);
		imprimir();
		System.out.println("Se eliminaron: " + registroCambio + " registros.");
	}
}
