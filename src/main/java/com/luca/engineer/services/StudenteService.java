package com.luca.engineer.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.luca.engineer.dto.ModificaStudenteRequest;
import com.luca.engineer.dto.NoleggiaLibroRequest;
import com.luca.engineer.dto.RegistraStudenteRequest;
import com.luca.engineer.models.Libro;
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
	
	public Studente modifica(ModificaStudenteRequest json) {
		
		Studente studente = new Studente();
		
		try {
			studente = entityManager.find(Studente.class, json.getId());
			studente.setNome(json.getNome());
			studente.setCognome(json.getCognome());
			studente.setDataNascita(json.getDataNascita());
			studente.setLuogoNascita(json.getLuogoNascita());
			studente.setTelefono(json.getTelefono());
		} catch (Exception e) {
			System.out.println("modifica non effettuata");
		}
		
		return studente;
		
	}
	
	@Transactional
	public Boolean noleggiaLibro(NoleggiaLibroRequest json) {
		
		Studente studente = entityManager.find(Studente.class, json.getIdStudente());
		Libro libro = entityManager.find(Libro.class, json.getIdLibro());
		
		if (studente == null || libro == null) {
			return false;
		}
		
		studente.noleggiaLibro(libro);
		libro.setStudente(studente);
		
		return true;
		
	}

}
