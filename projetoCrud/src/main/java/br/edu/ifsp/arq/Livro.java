package br.edu.ifsp.arq;

import java.util.ArrayList;

public class Livro {
	private int id;
	private String titulo;
	private String autor;
	private int ano;
	private ArrayList<String> generos;
	private static int contadorId = 1;


	public Livro(String titulo, String autor, int ano, ArrayList<String> generos) {
	    this.id = contadorId++;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.generos = generos;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setGeneros(ArrayList<String> generos) {
		this.generos = generos;
	}

	public String getAutor() {
		return autor;
	}

	public int getAno() {
		return ano;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	@Override
	public String toString() {
		String s = titulo + " - " + autor + " (" + ano + ")\n";
		for (String g : generos) {
			s += "Gênero: " + g + "\n";
		}
		return s;
	}


}
