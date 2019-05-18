package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.Conexion;

public class UsuarioController {
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}

	// Instancias la clase que hemos creado anteriormente
	private Conexion SQL = new Conexion();
	// Llamas al método que tiene la clase y te devuelve una conexión
	private Connection conn = SQL.conectarMySQL();
	// Query que usarás para hacer lo que necesites
	private String sSQL = "select * from usuario";

	public String listarUsuarios() {
		try {
			PreparedStatement pstm = conn.prepareStatement(sSQL);
			ResultSet resultado = pstm.executeQuery();
			while (resultado.next()) {
				System.out.println(resultado.getString("nombre"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}

}
