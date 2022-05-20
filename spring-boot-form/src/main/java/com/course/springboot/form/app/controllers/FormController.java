package com.course.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.course.springboot.form.app.domain.Pais;
import com.course.springboot.form.app.domain.Role;
import com.course.springboot.form.app.domain.Usuario;
import com.course.springboot.form.app.editors.NombreMayusculaEditor;
import com.course.springboot.form.app.editors.PaisPropertyEditor;
import com.course.springboot.form.app.editors.RolesEditor;
import com.course.springboot.form.app.services.PaisService;
import com.course.springboot.form.app.services.RoleService;
import com.course.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private PaisService paisService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolesEditor rolEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class,"nombre",new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class,"apellido",new NombreMayusculaEditor());
		binder.registerCustomEditor(Pais.class,"pais",paisEditor);
		binder.registerCustomEditor(Role.class,"roles",rolEditor);
	}
	
	@ModelAttribute("paises")
	public List<String> paises (){
		return Arrays.asList("España","México","El Salvador","Argentina", "Perú", "Colombia", "VEnezuela");
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises (){
		return paisService.listar();
	}
	
	@ModelAttribute("paisesMap")
	public Map<String,String> paisesMap (){
		Map<String,String> paises = new HashMap<>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("SV", "El Salvador");
		paises.put("AR", "Argentina");
		paises.put("PE", "Perú");
		paises.put("CO", "Colombia");
		paises.put("VE", "Venezuela");
		return paises;
	}
	
	@ModelAttribute("listaRoles")
	public List<Role> listaRoles(){
		return this.roleService.listar();
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString(){
		return Arrays.asList("ROLE_ADMIN","ROLE_USER", "ROLE_MODERATOR");
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String,String> listaRolesMap(){
		Map<String,String> roles = new HashMap<>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_USER", "Moderador");
		return roles;
	}
	
	@ModelAttribute("genero")
	public List<String> genero(){
		return Arrays.asList("Hombre","Mujer");
	}
	
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario user = new Usuario();
		
		user.setNombre("Kevin");
		user.setApellido("Orellana");
		user.setIdentificador("12.123.123-K");
		user.setHabilitar(true);
		user.setValorSecreto("Algún valor secreto");
		user.setPais(new Pais(3, "SV", "El Salvador"));
		user.setRoles(Arrays.asList(new Role (2,"Usuario","ROLE_USER")));
		model.addAttribute("titulo","Crear usuario");
		model.addAttribute("usuario",user);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Validated Usuario usuario,BindingResult result,Model model) {
		
//		validador.validate(usuario, result);
		
		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(err -> {
//				errores.put(err.getField(), "El campo".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
//			});
//			model.addAttribute("error",errores);
			model.addAttribute("titulo","Resultado Form");
			return "form";			
		}
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario,Model model, SessionStatus status) {
		if(usuario == null)
			return "redirect:/form";
		
		model.addAttribute("titulo","Resultado Form");
		
		status.setComplete();
		return "resultado";
	}
}
