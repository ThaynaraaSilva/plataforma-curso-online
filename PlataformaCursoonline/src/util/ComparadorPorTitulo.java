package util;

import java.util.Comparator;

import entidades.Curso;

public class ComparadorPorTitulo implements Comparator<Curso> {

	@Override
    public int compare(Curso c1, Curso c2) {
        return c1.getTitulo().compareTo(c2.getTitulo());
    }
}
