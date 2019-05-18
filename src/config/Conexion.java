package config;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {

	// Librería de MySQL
	public String driver = "com.mysql.jdbc.Driver";

	// Nombre de la base de datos
	public String database = "biblioteca";

	// Host
	public String hostname = "localhost";

	// Puerto
	public String port = "3306";

	// Ruta de nuestra base de datos (desactivamos el uso de SSL con
	// "?useSSL=false")
	public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

	// Nombre de usuario
	public String username = "root";

	// Clave de usuario
	public String password = "";

	public Connection conectarMySQL() {
		Connection conn = null;

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

}
