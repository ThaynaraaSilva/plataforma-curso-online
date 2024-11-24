package view;

import enums.TipoCurso;

public class MainEnum {
	public static void main(String[] args) {
		TipoCurso tipocurso = TipoCurso.ONLINE;
		System.out.println(tipocurso);
		System.out.println(tipocurso.name());
		System.out.println(tipocurso.ordinal());

		if (tipocurso == TipoCurso.PRESENCIAL) {
			System.out.println("CURSO PRESENCIAL");
		} else {
			System.out.println("CURSO DIFERENTE DE PRESENCIAL");
		}
	}

}
