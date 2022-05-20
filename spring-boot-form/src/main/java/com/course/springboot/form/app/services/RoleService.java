package com.course.springboot.form.app.services;

import java.util.List;

import com.course.springboot.form.app.domain.Role;


public interface RoleService {
	public List<Role> listar();
	public Role obtenerPorId(Integer id);
}
