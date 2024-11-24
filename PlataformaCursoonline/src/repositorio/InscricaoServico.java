package repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import exceptions.CursoNotFoundException;
import exceptions.InvalidAnoCriacaoException;
import entidades.Aluno;
import entidades.Curso;
import interfaces.IServicoInscricao;

public abstract class InscricaoServico implements IServicoInscricao {
    private Map<Curso, List<Aluno>> inscricoes;

    public InscricaoServico() {
        this.inscricoes = new HashMap<>();
    }

    @Override
    public void inscreverAluno(Curso curso, Aluno aluno) {
 
        inscricoes.computeIfAbsent(curso, k -> new ArrayList<>()).add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " inscrito no curso " + curso.getTitulo() + " com sucesso!");
    }

    @Override
    public void cancelarInscricao(Curso curso, Aluno aluno) throws CursoNotFoundException {
       
        List<Aluno> alunos = inscricoes.get(curso);
        
        if (alunos == null) {
            throw new CursoNotFoundException("Curso não encontrado.");
        }
        
      
        if (alunos.remove(aluno)) {
            System.out.println("Inscrição de " + aluno.getNome() + " no curso " + curso.getTitulo() + " cancelada com sucesso!");
        } else {
            System.out.println("Aluno não encontrado na lista de inscritos.");
        }
    }


    @Override
    public int calcularTotalAlunosInscritos(Curso curso) {
        List<Aluno> alunos = inscricoes.get(curso);
        return (alunos == null) ? 0 : alunos.size();
    }

    @Override
    public List<Curso> listarCursos() {
        return new ArrayList<>(inscricoes.keySet());
    }
}