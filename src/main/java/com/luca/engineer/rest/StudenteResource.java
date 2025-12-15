package com.luca.engineer.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.luca.engineer.dto.RegistraStudenteRequest;
import com.luca.engineer.models.Studente;
import com.luca.engineer.services.StudenteService;

@Path("/studente")
public class StudenteResource {

	@EJB
	private StudenteService studenteService;
	
	@POST
	@Path("/registra")
	@Consumes("application/json")
	@Produces("application/json")
	public Response registra(RegistraStudenteRequest json) {
		
		Studente studente = studenteService.registra(json);
		
		if (studente.getId() == null) {
			return Response.notModified().build();
		} else {
			return Response.ok(studente).build();
		}
	}
	
}
