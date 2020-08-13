package com.testebackend.api.entity;

import java.time.OffsetDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="trilha")
public class Trilha {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=35, message="não pode ser maior que 35 caracteres")
	@Column(name="trilha_nome")
	private String trilhaNome;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=30, message="não pode ser maior que 30 caracteres")
	@Column(name="diretoria")
	private String diretoria;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=270, message="não pode ser maior que 270 caracteres")
	@Column(name="missao_formal")
	private String missaoFormal;
	
	@NotNull(message="não pode ser nulo")
	@Size(max=126, message="não pode ser maior que 126 caracteres")
	@Column(name="missao_alternativa")
	private String missaoAlternativa;
	
	@Column(name="data_atualizacao")
	private OffsetDateTime dataAtualizacao;
	
	@OneToMany(mappedBy="trilha")
	@JsonIgnoreProperties("trilha")
	private List<Cargo> cargos;

	public Trilha() {
		
	}

	public Trilha(String trilhaNome, String diretoria, String missaoFormal, String missaoAlternativa, OffsetDateTime dataAtualizacao, List<Cargo> cargos) {
		this.trilhaNome = trilhaNome;
		this.diretoria = diretoria;
		this.missaoFormal = missaoFormal;
		this.missaoAlternativa = missaoAlternativa;
		this.dataAtualizacao = dataAtualizacao;
		this.cargos = cargos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrilhaNome() {
		return trilhaNome;
	}

	public void setTrilhaNome(String trilhaNome) {
		this.trilhaNome = trilhaNome;
	}

	public String getDiretoria() {
		return diretoria;
	}

	public void setDiretoria(String diretoria) {
		this.diretoria = diretoria;
	}

	public String getMissaoFormal() {
		return missaoFormal;
	}

	public void setMissaoFormal(String missaoFormal) {
		this.missaoFormal = missaoFormal;
	}

	public String getMissaoAlternativa() {
		return missaoAlternativa;
	}

	public void setMissaoAlternativa(String missaoAlternativa) {
		this.missaoAlternativa = missaoAlternativa;
	}

	public OffsetDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(OffsetDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}

}
