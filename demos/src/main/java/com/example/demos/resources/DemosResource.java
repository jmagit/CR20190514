package com.example.demos.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demos.ioc.Punto;

@RestController
@RequestMapping(path = "/demos")
public class DemosResource {
	
	@GetMapping()
	public String demo() {
		return "Hola mundo";
	}
	@GetMapping(path = "/punto", produces = {"application/xml"})
	public Punto puntoXML() {
		return new Punto(1, 2);
	}
	@GetMapping(path = "/punto", produces = {"application/json"})
	public Punto puntoJSON() {
		return new Punto(2, 1);
	}
	@GetMapping("/params/{id}")
	public String cotilla(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "\n");
	    sb.append("nom: " + nom + "\n");
	    sb.append("language: " + language + "\n");
	    return sb.toString();
	}
	@GetMapping(path = "/punto2")
	public String creaPunto(@RequestBody Punto item) {
		return item.toString();
	}

}
