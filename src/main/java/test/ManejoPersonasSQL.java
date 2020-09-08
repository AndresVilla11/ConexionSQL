package test;

import java.util.*;
import datos.PersonaDAO;
import domain.Persona;

public class ManejoPersonasSQL {

	public static void main(String[] args) {
		
	}

	public static void seleccionar() {
		PersonaDAO personaDao = new PersonaDAO();
		List<Persona> persona = personaDao.seleccionar();

		for (Persona personas : persona) {
			System.out.println("Persona: " + personas);
		}
	}

	public static void insertar() {
		PersonaDAO personaDao = new PersonaDAO();
		Persona persona = new Persona("Juan", "CCC", "123@mail", "12345");
		int registroCambio = personaDao.insertar(persona);
		seleccionar();
		System.out.println("Se cambiaron: " + registroCambio + " registros.");
	}
	
	public static void actualizar() {
		PersonaDAO personaDao = new PersonaDAO();
		Persona persona = new Persona(1,"ASDA","qwertyui","qwerq@mail","123456789987654");
		int registroCambio = personaDao.actualizar(persona);
		seleccionar();
		System.out.println("Se cambiaron: " + registroCambio + " registros.");		
	}

}