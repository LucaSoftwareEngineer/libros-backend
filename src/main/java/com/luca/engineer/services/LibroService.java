package com.luca.engineer.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.luca.engineer.dto.AggiungiLibroRequest;
import com.luca.engineer.dto.ModificaLibroRequest;
import com.luca.engineer.models.Libro;

@Stateless
public class LibroService {

	@PersistenceContext(unitName = "MyPU")
	private EntityManager entityManager;
	
	public Libro aggiungi(AggiungiLibroRequest json) {
		
		Libro libro = new Libro();
		libro.setTitolo(json.getTitolo());
		libro.setAutore(json.getAutore());
		libro.setDataPubblicazione(json.getDataPubblicazione());
		libro.setDataRegistrazioneInBiblioteca(json.getDataRegistrazioneInBiblioteca());
		
		try {
			entityManager.persist(libro);
		} catch (Exception e) {
			return null;
		}
		
		return libro;
	}
	
	public Libro modifica(ModificaLibroRequest json) {
		
		Libro libro = new Libro();
		
		try {
			
			libro = entityManager.find(Libro.class, json.getId());
			
			libro.setTitolo(json.getTitolo());
			libro.setAutore(json.getAutore());
			libro.setDataPubblicazione(json.getDataPubblicazione());
			libro.setDataRegistrazioneInBiblioteca(json.getDataRegistrazioneInBiblioteca());
			
		} catch (Exception e) {
			
			System.out.println("modifica non effettuata");
			
		}
		
		return libro;
		
	}
}
