package com.iwcn.master.pro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Producto {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public String codigo;
	
	public String nombre;
	
	public String descripcion;
	
	public Integer precio;
	
	protected Producto () {
		
	}
	// Getters y setters

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id=id;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
}
