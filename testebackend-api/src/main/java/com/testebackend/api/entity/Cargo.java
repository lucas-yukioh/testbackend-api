package com.testebackend.api.entity;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="cargo")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=53, message="não pode ser maior que 53 caracteres")
	@Column(name="cargo_nome")
	private String cargoNome;
	
	@NotNull(message="não pode ser nulo")
	@ManyToOne
	@JoinColumn(name="trilha_id")
	@JsonIgnoreProperties("cargos")
	private Trilha trilha;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=492, message="não pode ser maior que 492 caracteres")
	@Column(name="cargo_missao")
	private String cargoMissao;
	
	@Column(name="data_atualizacao")
	private OffsetDateTime dataAtualizacao;
	
	public Cargo() {
		
	}

	public Cargo(String cargoNome, Trilha trilha, String cargoMissao, OffsetDateTime dataAtualizacao) {
		this.cargoNome = cargoNome;
		this.trilha = trilha;
		this.cargoMissao = cargoMissao;
		this.dataAtualizacao = dataAtualizacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCargoNome() {
		return cargoNome;
	}

	public void setCargoNome(String cargoNome) {
		this.cargoNome = cargoNome;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}

	public String getCargoMissao() {
		return cargoMissao;
	}

	public void setCargoMissao(String cargoMissao) {
		this.cargoMissao = cargoMissao;
	}

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
