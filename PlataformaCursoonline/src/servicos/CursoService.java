package servicos;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import entidades.Curso;
import enums.TipoCurso;
import entidades.Aluno;
import exceptions.CursoNotFoundException;
import interfaces.ICursoRepositorio;
import interfaces.IServicoInscricao;
public class CursoService implements IServicoInscricao {
    private ICursoRepositorio cursoRepositorio;

   
    public CursoService(ICursoRepositorio cursoRepositorio) {
        this.cursoRepositorio = cursoRepositorio;
    }

    @Override
    public void adicionarCurso(Curso curso) {

        cursoRepositorio.adicionarCurso(curso);
        System.out.println("Curso " + curso.getTitulo() + " adicionado com sucesso!");
    }

    @Override
    public int calcularTotalAlunosInscritos(Curso curso) {
       
    	   List<Aluno> alunosInscritos = ((ICursoRepositorio) cursoRepositorio).listarAlunosInscritos(curso);
           return alunosInscritos.size();
    }

    @Override
    public void inscreverAluno(Curso curso, Aluno aluno) {
       
    	 ((ICursoRepositorio) cursoRepositorio).inscreverAluno(curso, aluno);
         System.out.println("Aluno " + aluno.getNome() + " inscrito no curso " + curso.getTitulo());
    }

    @Override
    public void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException {
  
    	   ((ICursoRepositorio) cursoRepositorio).cancelarInscricao(curso, aluno);
           System.out.println("Inscrição do aluno " + aluno.getNome() + " cancelada no curso " + curso.getTitulo());
      
    }

    @Override
    public List<Curso> listarCursos() {
    
    	  List<Curso> cursos = cursoRepositorio.listarCursos();
          for (Curso curso : cursos) {
              System.out.println("Curso: " + curso.getTitulo() + " | ID: " + curso.getId());
          }
          return cursos; 
    }
   
}

	
	
   

