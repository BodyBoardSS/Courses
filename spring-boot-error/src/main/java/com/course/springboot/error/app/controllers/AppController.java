/**
 * 
 */
package com.course.springboot.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author BodyBoardSS
 * Date: 2022-06-16
 */

@Controller
public class AppController {
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
}
