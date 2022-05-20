package com.course.springboot.form.app.services;

import java.util.List;

import com.course.springboot.form.app.domain.Pais;

public interface PaisService {
	public List<Pais> listar();
	
	public Pais obtenerPorId(Integer id);
}
