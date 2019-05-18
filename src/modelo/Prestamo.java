package modelo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
// @Entity
// @Table(name="prestamo")
public class Prestamo implements Serializable {

	private int idPrestamo;
	private Date fechaPrestamo;
	private Date fechaEntrega;

	private Usuario usuario;
	private Libro libro;

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fechaEntrega == null) ? 0 : fechaEntrega.hashCode());
		result = prime * result
				+ ((fechaPrestamo == null) ? 0 : fechaPrestamo.hashCode());
		result = prime * result + idPrestamo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prestamo other = (Prestamo) obj;
		if (fechaEntrega == null) {
			if (other.fechaEntrega != null)
				return false;
		} else if (!fechaEntrega.equals(other.fechaEntrega))
			return false;
		if (fechaPrestamo == null) {
			if (other.fechaPrestamo != null)
				return false;
		} else if (!fechaPrestamo.equals(other.fechaPrestamo))
			return false;
		if (idPrestamo != other.idPrestamo)
			return false;
		return true;
	}

}
