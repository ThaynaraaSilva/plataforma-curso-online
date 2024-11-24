package view;

import java.sql.SQLException;
import java.util.List;

import entidades.Curso;
import entidades.CursoPresencial;
import enums.TipoCurso;
import repositorio.CursoRepositorio;

public class MainSql {

    public static void main(String[] args) throws SQLException {
        CursoRepositorio cursoRepositorio = new CursoRepositorio();
            Curso curso1 = new CursoPresencial(
                    "C001", 
                    "Curso de Java", 
                    "Curso básico de programação Java", 
                    2024, 
                    60, 
                    300.0, 
                    TipoCurso.PRESENCIAL, null, 0
            );

         
            cursoRepositorio.salvar(curso1);
            System.out.println("Curso salvo com sucesso!");

            for (Curso curso : cursoRepositorio.listarCursos()) {
                System.out.println("Código: " + curso.getId() +
                                   ", Título: " + curso.getTitulo() +
                                   ", Ano: " + curso.getAnoCriacao() +
                                   ", Tipo: " + curso.getTipo());
            }

    
    }
}
