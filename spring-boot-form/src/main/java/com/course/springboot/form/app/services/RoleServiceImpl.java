package com.course.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.course.springboot.form.app.domain.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	private List<Role> roles;
	
	public RoleServiceImpl() {
		this.roles = new ArrayList<>();
		this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
		this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
		this.roles.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
	}

	@Override
	public List<Role> listar() {
		return roles;
	}

	@Override
	public Role obtenerPorId(Integer id) {
		return roles.stream().filter(r -> r.getId() == id).findAny().orElse(null);
	}

}
