package com.luca.engineer.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.luca.engineer.dto.AggiungiLibroRequest;
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
	
}
