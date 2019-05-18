package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import config.Conexion;
import modelo.Usuario;

public class UsuarioController {

	private Conexion SQL = new Conexion();

	private Connection conn = SQL.conectarMySQL();

	private String sSQL;

	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			sSQL = "select * from usuario";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				Usuario nuevo = new Usuario();
				nuevo.setIdUsuario(resultado.getInt("idusuario"));
				nuevo.setNombre(resultado.getString("nombre"));
				nuevo.setIdentificacion(resultado.getInt("identificacion"));
				nuevo.setRol(resultado.getString("rol"));
				usuarios.add(nuevo);
			}
		} catch (Exception e) {
			System.out.println("Ocurrio un error al momento de listar los usuarios");
			e.printStackTrace();
		}
		return usuarios;
	}

	public String crearUsuario(String nombre, int identificacion, String rol) {
		try {
			if (validarUsuarioRegistrado(identificacion)) {
				return "Usuario registrado";
			}
			sSQL = "INSERT INTO `usuario` (`nombre`, `identidicacion`, `rol`) VALUES ('" + nombre + "', '"
					+ identificacion + "', '" + rol + "');";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				return "Usuario registrado con exito";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "Ocurrio algun problema al momento de registrar al usuario";
	}

	private boolean validarUsuarioRegistrado(int identificacion) {
		ArrayList<Usuario> usuarios = listarUsuarios();
		for (Usuario u : usuarios) {
			if (u.getIdentificacion() == identificacion) {
				return true;
			}
		}
		return false;
	}

	public String modificarUsuario(String nombre, int identificacion, String rol) {
		try {

			if (validarUsuarioRegistrado(identificacion)) {
				return "Usuario registrado";
			}
			
			sSQL ="UPDATE `usuario` SET `nombre` = '" + nombre + "', `rol` = '"+ rol +"' WHERE `usuario`.`identificacion` = "+ identificacion +";";
			PreparedStatement preparado = conn.prepareStatement(sSQL);
			ResultSet resultado = preparado.executeQuery();
			while (resultado.next()) {
				return "Usuario modificado con exito";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "Ocurrio algun problema al momento de modificar al usuario";
	}

	public Usuario buscarUsuario(int identificacion) {
		ArrayList<Usuario> usuarios = listarUsuarios();
		for (Usuario u : usuarios) {
			if (u.getIdentificacion() == identificacion) {
				return u;
			}
		}
		return null;
	}

}
