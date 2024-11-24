package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import entidades.Curso;
import exceptions.CursoNotFoundException;
import entidades.Aluno;

public interface IServicoInscricao {
	void adicionarCurso(Curso curso);

	int calcularTotalAlunosInscritos(Curso curso);

	void inscreverAluno(Curso curso, Aluno aluno);

	void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException;

	List<Curso> listarCursos();
}
