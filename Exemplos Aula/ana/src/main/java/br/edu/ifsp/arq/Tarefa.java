package br.edu.ifsp.arq;

import java.io.Serializable;

public class Tarefa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	private static int proximo_id = 0;
	private int id;
	
	public Tarefa() {
		this.id = ++proximo_id;
	}
	
	public Tarefa(String n, String d) {
		this.descricao = d;
		this.nome = n;
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
	public int getId() {
		return id;
	}
	
}
