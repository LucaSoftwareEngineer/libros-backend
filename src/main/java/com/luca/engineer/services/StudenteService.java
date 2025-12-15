package com.luca.engineer.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.luca.engineer.dto.RegistraStudenteRequest;
import com.luca.engineer.models.Studente;

@Stateless
public class StudenteService {
	
	@PersistenceContext(unitName = "MyPU")
	private EntityManager entityManager;
	
	public Studente registra(RegistraStudenteRequest json) {
		
		Studente studente = new Studente();
		
		try {
			studente.setNome(json.getNome());
			studente.setCognome(json.getCognome());
			studente.setDataNascita(json.getDataNascita());
			studente.setLuogoNascita(json.getLuogoNascita());
			studente.setTelefono(json.getTelefono());
			
			entityManager.persist(studente);
			
		} catch (Exception e) {
			
			System.out.println("registrazione non effettuata");
		
		}
		
		return studente;
		
	}

}
