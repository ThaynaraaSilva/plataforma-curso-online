package entidades;

import java.util.ArrayList;
import java.util.UUID;

import enums.TipoCurso;

public abstract class Curso implements Comparable<Curso> {
	private String id;
	private String titulo;
	private String descricao;
	private int anoCriacao;
	private int DuracaoHoras;
	private double preco;
	private TipoCurso tipo;
	private ArrayList<Aluno> alunos;

	public Curso(String id,String titulo, String descricao, int anoCriacao, int DuracaoHoras, double preco,TipoCurso tipo) {
		this.id = id != null ? id : UUID.randomUUID().toString();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.anoCriacao = anoCriacao;
		this.DuracaoHoras = DuracaoHoras;
		this.preco = preco;
		this.tipo = tipo;
		this.alunos = new ArrayList<Aluno>();
	}
	
	
	 public int compareTo1(Curso outro) {
		 return this.titulo.compareTo(outro.titulo);
	    }

	    @Override
	    public String toString() {
	        return "Curso [ID=" + id + ", Titulo=" + titulo + "]";
	    }
	
	public Curso() {
		
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public int getAnoCriacao() {
		return anoCriacao;
	}


	public void setAnoCriacao(int anoCriacao) {
		this.anoCriacao = anoCriacao;
	}


	public int getDuracaoHoras() {
		return DuracaoHoras;
	}


	public void setDuracaoHoras(int duracaoHoras) {
		DuracaoHoras = duracaoHoras;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public TipoCurso getTipo() {
		return tipo;
	}


	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}


	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}


	public void avaliarCurso() {
		
	}
	
	}