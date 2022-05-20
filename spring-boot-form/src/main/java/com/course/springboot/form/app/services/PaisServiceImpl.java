/**
 * 
 */
package com.course.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.springboot.form.app.domain.Pais;

/**
 * @author BodyBoardSS Date: 2022-05-14
 */

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> lista;

	public PaisServiceImpl() {
		this.lista = Arrays.asList(new Pais(1, "ES", "España"), new Pais(2, "MX", "México"),
				new Pais(3, "SV", "El Salvador"), new Pais(4, "AR", "Argentina"), new Pais(5, "PE", "Perú"),
				new Pais(6, "CO", "Colombia"), new Pais(7, "VE", "Venezuela"));
	}

	@Override
	public List<Pais> listar() {
		return this.lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		return lista.stream().filter(r -> r.getId() == id).findAny().orElse(null);
	}

}
