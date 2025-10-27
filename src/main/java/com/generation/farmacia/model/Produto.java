package com.generation.farmacia.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private Long id;

	@Column(length = 255)
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 3, message = "O atributo nome deve conter no mínimo 3 caracteres")
	private String nome;

	@Column(length = 10000)
	@NotBlank(message = "O atributo descricao é obrigatório!")
	@Size(min = 5, message = "O atributo descricao deve conter no mínimo 5 caracteres")
	private String descricao;

	@NotBlank(message = "O atributo imagem é obrigatório!")
	private String imagem;
	
	@ManyToOne
	@JsonIgnoreProperties("Categoria")
	private Categoria categoria;
		
	@Column(updatable = false) // Quero que depois que a data foi criada no momento que o produto foi inserido no sistema e não mude mais depois disso.
	@JsonFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
	private LocalDateTime data;

	@NotNull(message = "O atributo estoque é obrigatório!")
	private Long estoque;

	@NotNull(message = "O atributo valor é obrigatório!")
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

		
	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getEstoque() {
		return estoque;
	}

	public void setEstoque(Long estoque) {
		this.estoque = estoque;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
	
}
