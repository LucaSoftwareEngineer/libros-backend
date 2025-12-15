package com.luca.engineer.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AggiungiLibroRequest {

	private String titolo;
	private String autore;
	private LocalDate dataPubblicazione;
	private LocalDate dataRegistrazioneInBiblioteca;
	
}
