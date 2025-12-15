package com.luca.engineer.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "libri")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lib_id")
	private Long id;
	
	@Column(name = "lib_titolo", nullable = false)
	private String titolo;
	
	@Column(name = "lib_autore", nullable = false)
	private String autore;
	
	@Column(name = "lib_data_pubblicazione", nullable = false)
	private LocalDate dataPubblicazione;
	
	@Column(name = "lib_data_registrazione_in_biblioteca", nullable = false)
	private LocalDate dataRegistrazioneInBiblioteca;
	
	@ManyToOne
	@JoinColumn(name = "lib_stu_id", nullable = true)
	private Studente studente;
	
}
