package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.Conexion;
import modelo.Libro;

public class LibroController {

	private Conexion SQL = new Conexion();

	private Connection conn = SQL.conectarMySQL();

	private String sSQL;

	public ArrayList<Libro> listarLibros() {
		ArrayList<Libro> Libros = new ArrayList<Libro>();

		try {
			sSQL = "select * from Libro";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				Libro nuevo = new Libro();
				nuevo.setIsbn(resultado.getInt("isbn"));
				nuevo.setNombre(resultado.getString("nombre"));
				nuevo.setCantidad(resultado.getInt("cantidad"));
				nuevo.setPalindromo(resultado.getBoolean("palindromo"));
				Libros.add(nuevo);
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un error al momento de listar los Libros");
			e.printStackTrace();
		}
		return Libros;
	}

	public String crearLibro(int isbn,String nombre,int cantidad,boolean palindromo) {
		try {
			if (validarLibroRegistrado(isbn)) {
				return "Libro registrado";
			}
			sSQL = "INSERT INTO `Libro` (`nombre`, `identidicacion`, `rol`) VALUES ('" + nombre + "', '"
					+ identificacion + "', '" + rol + "');";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				return "Libro registrado con exito";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "Ocurrio algun problema al momento de registrar al Libro";
	}

	private boolean validarLibroRegistrado(int identificacion) {
		ArrayList<Libro> Libros = listarLibros();
		for (Libro u : Libros) {
			if (u.getIdentificacion() == identificacion) {
				return true;
			}
		}
		return false;
	}

	public String modificarLibro(String nombre, int identificacion, String rol) {
		try {

			if (validarLibroRegistrado(identificacion)) {
				return "Libro registrado";
			}

			sSQL = "UPDATE `Libro` SET `nombre` = '" + nombre + "', `rol` = '" + rol
					+ "' WHERE `Libro`.`identificacion` = " + identificacion + ";";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				return "Libro modificado con exito";
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Ocurrio algun problema al momento de modificar al Libro";
	}

	public Libro buscarLibro(int identificacion) {
		ArrayList<Libro> Libros = listarLibros();
		for (Libro u : Libros) {
			if (u.getIdentificacion() == identificacion) {
				return u;
			}
		}
		return null;
	}

}
