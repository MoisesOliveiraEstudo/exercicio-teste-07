package com.fatec.biblioteca;

import static org.junit.jupiter.api.Assertions.*;

import javax.naming.directory.InvalidAttributeValueException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fatec.biblioteca.model.Livro;
import com.fatec.biblioteca.repository.LivroRepository;

@SpringBootTest
class REQ01CadastrarLivroTests {

	@Autowired
	LivroRepository repo;
	
	@Test
	void ct0_cadastrar_livro_com_sucesso() {
		Livro livro = new Livro();
		try {
			livro.setISBN(9354124);
			livro.setAutor("Autor");
			livro.setTitulo("Titulo");
			livro.setEdicao("24");
		} catch (InvalidAttributeValueException e) {
			e.printStackTrace();
		}
		
		repo.save(livro);
	}

	@Test
	void ct01_isbn_invalido() {
		try {
			Livro livro = new Livro(-6242, "Titulo", "Autor", "Editora", 2021, "2");
			fail("Erro");
		}
		catch(Exception e) {
			assertEquals("ISBN não pode ser zero", e.getMessage());
		}
	}
	
	@Test
	void ct02_isbn_valido() {
		try {
			Livro livro = new Livro(242, "Titulo", "Autor", "Editora", 2010, "23");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void ct03_titulo_invalido() {
		try {
			Livro livro = new Livro(452, "", "Autor", "Editora", 2028, "243");
			fail("Erro");
		} 
		
		catch (Exception e) {
			assertEquals("Digite um valor para o titulo valido", e.getMessage());
		}
	}
	
	@Test
	void ct04_autor_invalido() {
		try {
			Livro livro = new Livro(2425, "Titulo", new String(""), "Editora", 2011, "67");
			fail("Erro");
		} 
		
		catch (Exception e) {
			assertEquals("Digite um autor valido", e.getMessage());
		}
	}
	
	@Test
	void ct05_editora_invalida() {
		try {
			Livro livro = new Livro(2663, "Titulo", "Autor", "", 2012, "54");
			fail("Erro na editora");
		} 
		
		catch (Exception e) {
			assertEquals("Digite uma editora valida", e.getMessage());
		}
	}
	
	@Test
	void ct06_ano_invalido() {
		try {
			Livro livro = new Livro(2663, "Titulo", "Autor", "Editora", 2027, "54");
			fail("Erro no ano");
		} 
		
		catch (Exception e) {
			assertEquals("Digite um ano valido", e.getMessage());
		}
	}
	
	
}
