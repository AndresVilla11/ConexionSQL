package test;

import java.sql.*;
import java.util.*;
import datos.*;
import domain.*;

public class ManejoPersonasSQL {

	public static void main(String[] args) throws SQLException {
		Connection conexion = Conexion.getConnection();
		if(conexion.getAutoCommit()) {
			conexion.setAutoCommit(false);
		}
		int opcion = -1;
		Scanner teclado = new Scanner(System.in);
		Persona persona = new Persona();
		while (opcion != 0) {
			System.out.println("\n" + "Bienvenido, que accion desea realizar: \n" + "1. Imprimir lista de usuarios. \n"
					+ "2. Imprimir un usuario. \n" + "3. Insertar un usuario nuevo. \n"
					+ "4. Actualizar datos de un usuario. \n" + "5. Eliminar un usuario. \n");
			opcion = Integer.parseInt(teclado.nextLine());
			switch (opcion) {
			case 1:
				AccesoDatos.imprimir();
				conexion.commit();
				break;
			case 2:
				System.out.println("Ingrese en ID del usuario a actualizar: \n");
				AccesoDatos.imprimirUsuario(Integer.parseInt(teclado.nextLine()));
				conexion.commit();
				break;
			case 3:
				System.out.println("Escriba el nombre del usuario: \n");
				persona.setNombre(teclado.nextLine());
				System.out.println("Escriba el apellido del usuario: \n");
				persona.setApellido(teclado.nextLine());
				System.out.println("Escribe el email del usuario: \n");
				persona.setEmail(teclado.nextLine());
				System.out.println("Escribe el telefono del usuario: \n");
				persona.setTelefono(teclado.nextLine());
				AccesoDatos.insertar(persona);
				conexion.commit();
				break;
			case 4:
				int idActualizar = -1;
				System.out.println("Ingrese en ID del usuario a actualizar: \n");
				idActualizar = Integer.parseInt(teclado.nextLine());
				persona.setIdPersona(idActualizar);
				System.out.println("Escriba el nombre del usuario: \n");
				persona.setNombre(teclado.nextLine());
				System.out.println("Escriba el apellido del usuario: \n");
				persona.setApellido(teclado.nextLine());
				System.out.println("Escribe el email del usuario: \n");
				persona.setEmail(teclado.nextLine());
				System.out.println("Escribe el telefono del usuario: \n");
				persona.setTelefono(teclado.nextLine());
				AccesoDatos.actualizar(persona);
				conexion.commit();
				break;
			case 5:
				int idEliminar = -1;
				System.out.println("Ingrese en ID del usuario a actualizar: \n");
				idEliminar = Integer.parseInt(teclado.nextLine());
				persona.setIdPersona(idEliminar);
				AccesoDatos.eliminar(persona);
				conexion.commit();
				break;
			case 0:
				System.out.println("Hasta luego.");
				conexion.commit();
				break;
			default:
				System.out.println("Opcion no reconocida.");
				conexion.commit();
				break;
			}
		}
	}
}