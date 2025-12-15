package com.luca.engineer.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.luca.engineer.dto.AggiungiLibroRequest;
import com.luca.engineer.models.Libro;
import com.luca.engineer.services.LibroService;

@Path("/libro")
public class LibroResource {
	
	@EJB
	private LibroService libroService;
	
	@POST
	@Path("/aggiungi")
	@Consumes("application/json")
	@Produces("application/json")
	public Response aggiungi(AggiungiLibroRequest json) {
		
		Libro libro = libroService.aggiungi(json);
		
		if (libro.getId().equals(null)) {
			return Response.notModified().build();
		} else {
			return Response.ok(libro).build();
		}
		
	}

}
