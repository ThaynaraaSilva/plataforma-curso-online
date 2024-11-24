package entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends EntidadeBasica {

	private String id;
	private String nome;
	private String email;
	private String matricula;
	private List<Curso> cursosInscritos;

	public Aluno(String id, String nome, String email, String matricula) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.cursosInscritos = new ArrayList<>();

	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getMatricula() {
		return matricula;
	}

	public List<Curso> getCursosInscritos() {
		return cursosInscritos;
	}

	public void inscreverCurso(Curso curso) {
		System.out.println("Aluno " + nome + " se inscreveu no curso " + curso.getTitulo());
		curso.avaliarCurso();
	}

	public void avaliarCurso(Curso curso) {

	}
}
