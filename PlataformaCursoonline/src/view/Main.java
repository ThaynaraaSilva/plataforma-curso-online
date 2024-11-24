package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entidades.Curso;
import enums.TipoCurso;
import util.ComparadorPorTitulo; 

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(2, "Python Básico", "Descrição", 2023, 30, 80.0, TipoCurso.ONLINE));
        cursos.add(new Curso(1, "Java Avançado", "Descrição", 2022, 50, 150.0, TipoCurso.PRESENCIAL));
        cursos.add(new Curso(3, "Estruturas de Dados", "Descrição", 2023, 40, 200.0, TipoCurso.ONLINE));

     
        Collections.sort(cursos, new ComparadorPorTitulo());


        System.out.println("Cursos ordenados por título:");
        cursos.forEach(System.out::println);
    }
}
