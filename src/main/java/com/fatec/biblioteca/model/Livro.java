package com.fatec.biblioteca.model;

import java.time.LocalDate;

import javax.naming.directory.InvalidAttributeValueException;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Livro {

	@Id
	private int ISBN;
	private String titulo;
	private String autor;
	private String editora;
	private int ano;
	private String edicao;

	public Livro() {

	}

	public Livro(int iSBN, String titulo, String autor, String editora, int ano, String edicao) throws InvalidAttributeValueException {
		super();
		setISBN(iSBN); 
		setTitulo(titulo);
		setAutor(autor);
		setEditora(editora);
		setAno(ano);
		setEdicao(edicao);
		//this.autor = autor;
		//this.editora = editora;
		//this.ano = ano;
		//this.edicao = edicao;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) throws InvalidAttributeValueException {
		if (iSBN > 0) {
			ISBN = iSBN;
		} else {
			throw new InvalidAttributeValueException("ISBN não pode ser zero");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws InvalidAttributeValueException {
		if (!titulo.isEmpty() || !titulo.isBlank()) {
			this.titulo = titulo;
		} else {
			throw new InvalidAttributeValueException("Digite um valor para o titulo valido");
		}
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) throws InvalidAttributeValueException {
		if (!autor.isEmpty() || !autor.isBlank()) {
			this.autor = autor;
		} else {
			throw new InvalidAttributeValueException("Digite um autor valido");
		}
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) throws InvalidAttributeValueException {
		if (!editora.isEmpty() || !editora.isBlank()) {
			this.editora = editora;
		} else {
			throw new InvalidAttributeValueException("Digite uma editora valida");
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) throws InvalidAttributeValueException {
		if (ano > LocalDate.now().getYear()) {
			throw new InvalidAttributeValueException("Digite um ano valido");
		} else {
			this.ano = ano;
		}

	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) throws InvalidAttributeValueException {
		if (!edicao.isEmpty() || !edicao.isBlank()) {
			for(int i = 0; i < edicao.length(); i++) {
				if(!(edicao.charAt(i) == '#') | !(edicao.charAt(i) == ')') | !(edicao.charAt(i) == '%')){
					this.edicao = edicao;
				}
				else {
					throw new InvalidAttributeValueException("Digite uma editora valida");
				}
			}
			
		} else {
			throw new InvalidAttributeValueException("Digite uma editora valida");
		}
	}

}
