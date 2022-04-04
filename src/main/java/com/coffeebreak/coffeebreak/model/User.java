package com.coffeebreak.coffeebreak.model;

import javax.persistence.*;


@Entity
@Table(name = "usuarios")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "alimento", unique = true)
	private String  alimento;
	
	public User() {
	}
	public User(String nome, String cpf, String email, String alimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.alimento=alimento;
	}
	
	public long getId() {
		return id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCpf() {
		return this.cpf;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
	public void setAlimento(String alimento) {
		this.alimento = alimento;
	}
	public String getAlimento() {
		return this.alimento;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", cpf=" + getCpf() + ", email=" + getEmail() + ", nome=" + getNome() + ", Alimento=" + getAlimento()+ "]";
	}
}