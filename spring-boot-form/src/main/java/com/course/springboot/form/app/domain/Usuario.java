/**
 * 
 */
package com.course.springboot.form.app.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import com.course.springboot.form.app.validation.IdentificadorRegex;
import com.course.springboot.form.app.validation.Requerido;

/**
 * @author BodyBoardSS Date: 2022-05-11
 */
public class Usuario {
	
	//@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;

	//@NotEmpty(message = "el nombre no puede ser vacio")
	private String nombre;

	@Requerido
	private String apellido;

	@NotBlank
	@Size(min = 3, max = 8)
	private String userName;

	@NotBlank
	private String password;

	@Requerido
	@Email
	private String email;
	
	@NonNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	
//	@Future
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NonNull
	@Past
	private Date fechaNacimiento;
	
	@NonNull
	private Pais pais;
	
	@NotEmpty
	private List<Role> roles;
	
	private Boolean habilitar;
	
	@NotEmpty
	private String genero;
	
	private String valorSecreto;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the indentificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * @param indentificador the indentificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the cuenta
	 */
	public Integer getCuenta() {
		return cuenta;
	}

	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the habilitar
	 */
	public Boolean getHabilitar() {
		return habilitar;
	}

	/**
	 * @param habilitar the habilitar to set
	 */
	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the valorSecreto
	 */
	public String getValorSecreto() {
		return valorSecreto;
	}

	/**
	 * @param valorSecreto the valorSecreto to set
	 */
	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}
}
