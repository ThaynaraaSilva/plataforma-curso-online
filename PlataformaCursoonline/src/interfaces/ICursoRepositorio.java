package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Aluno;
import entidades.Curso;
import enums.TipoCurso;

public interface ICursoRepositorio {

	void adicionarCurso(Curso curso);

	void atualizar(Curso curso);

	void removerCurso(String id);
	
	List<Curso> listarCursos();

	Curso buscarCursoPorId(String id);

	void inscreverAluno(Curso curso, Aluno aluno);

	boolean cancelarInscricao(Curso curso, Aluno aluno);

	List<Aluno> listarAlunosInscritos(Curso curso);

	void salvar(Curso curso);

	void alterar(Curso curso);
}
