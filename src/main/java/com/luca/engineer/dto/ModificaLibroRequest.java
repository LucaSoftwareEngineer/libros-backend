package com.luca.engineer.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaLibroRequest {

	private Long id;
	private String titolo;
	private String autore;
	private LocalDate dataPubblicazione;
	private LocalDate dataRegistrazioneInBiblioteca;
	
}
