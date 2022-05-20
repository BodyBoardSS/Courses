/**
 * 
 */
package com.course.springboot.form.app.domain;

/**
 * @author BodyBoardSS
 * Date: 2022-05-14
 */
public class Pais {
	
	private Integer id;
	private String codigo;
	private String nombre;
	
	public Pais() {
	}

	public Pais(Integer id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return this.id.toString();
	}
	
	
}
