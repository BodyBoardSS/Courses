package com.course.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.course.springboot.form.app.domain.Usuario;
import com.course.springboot.form.app.editors.NombreMayusculaEditor;
import com.course.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class,"nombre",new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class,"apellido",new NombreMayusculaEditor());
	}
	
	@ModelAttribute("paises")
	public List<String> paises (){
		return Arrays.asList("España","México","El Salvador","Argentina", "Perú", "Colombia", "VEnezuela");
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		Usuario user = new Usuario();
		
		user.setNombre("Kevin");
		user.setApellido("Orellana");
		user.setIdentificador("12.123.123-K");
		model.addAttribute("titulo","Crear usuario");
		model.addAttribute("usuario",user);
		return "form";
	}
	
	@PostMapping("/form")
	public String procesar(@Validated Usuario usuario,BindingResult result,Model model, SessionStatus status) {
		
//		validador.validate(usuario, result);
		
		if(result.hasErrors()) {
//			Map<String, String> errores = new HashMap<>();
//			result.getFieldErrors().forEach(err -> {
//				errores.put(err.getField(), "El campo".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
//			});
//			model.addAttribute("error",errores);
			
			return "form";			
		}
		
		model.addAttribute("titulo","Resultado Form");
		model.addAttribute("usuario",usuario);
		status.setComplete();
		return "resultado";
	}
}
