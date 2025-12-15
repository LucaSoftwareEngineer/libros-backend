package com.luca.engineer.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.luca.engineer.dto.ModificaStudenteRequest;
import com.luca.engineer.dto.ModificaStudenteResponse;
import com.luca.engineer.dto.NoleggiaLibroRequest;
import com.luca.engineer.dto.NoleggiaLibroResponse;
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
	
	@PUT
	@Path("/modifica")
	@Consumes("application/json")
	@Produces("application/json")
	public Response modifica(ModificaStudenteRequest json) {
		
		Studente studente = studenteService.modifica(json);
		
		if (studente.getId() == null) {
			return Response.notModified().build();
		} else {
			ModificaStudenteResponse res = new ModificaStudenteResponse();
			res.setId(studente.getId());
			res.setNome(studente.getNome());
			res.setCognome(studente.getCognome());
			res.setDataNascita(studente.getDataNascita());
			res.setLuogoNascita(studente.getLuogoNascita());
			res.setTelefono(studente.getTelefono());
			return Response.ok(res).build();
		}
	}
	
	@PUT
	@Path("/noleggia/libro")
	@Consumes("application/json")
	@Produces("application/json")
	public Response noleggiaLibro(NoleggiaLibroRequest json) {
		
		Boolean esito = studenteService.noleggiaLibro(json);
		
		if (esito) {
			NoleggiaLibroResponse res = new NoleggiaLibroResponse();
			res.setEsito(esito);
			return Response.ok(res).build();
		}
		return Response.notModified().build();		
	}
	
}
