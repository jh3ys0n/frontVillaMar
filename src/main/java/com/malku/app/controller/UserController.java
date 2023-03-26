package com.malku.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.malku.app.persistence.entity.User;
import com.malku.app.service.UserService;

import jakarta.annotation.security.PermitAll;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 6000)
@RestController
@RequestMapping("/api/users/")
public class UserController {

	 private UserService service;

	    public UserController(UserService service) {
	        this.service = service;
	    }

	    @PermitAll
	    @GetMapping("findAll")
	    public ResponseEntity<Iterable<User>> findAll() {
	        Iterable<User> usersResponse = service.findAll();
	        return ResponseEntity.ok(usersResponse);
	    }
	    
	    @PermitAll
		@PostMapping("usuario")
		public ResponseEntity guardar(@RequestParam("nombre")String nombre,@RequestParam("pass")String pass){
			service.guardar(nombre, pass);
		 
			return new ResponseEntity(HttpStatus.OK);
		}
}
