package com.luca.engineer.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificaStudenteRequest {

	private Long id;
	private String nome;
	private String cognome;
	private LocalDate dataNascita;
	private String luogoNascita;
	private String telefono;
	
}
