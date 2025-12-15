package com.luca.engineer.models;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "studenti")
@EqualsAndHashCode
public class Studente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stu_id")
	private Long id;
	
	@Column(name = "stu_nome", nullable = false)
	private String nome;
	
	@Column(name = "stu_cognome", nullable = false)
	private String cognome;
	
	@Column(name = "stu_data_nascita", nullable = false)
	private LocalDate dataNascita;
	
	@Column(name = "stu_luogo_nascita", nullable = false)
	private String luogoNascita;
	
	@Column(name = "stu_telefono", nullable = false)
	private String telefono;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "studente")
	private Set<Libro> libriNoleggiati;
	
}
