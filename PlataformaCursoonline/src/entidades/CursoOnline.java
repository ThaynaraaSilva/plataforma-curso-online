package entidades;

import java.util.Date;

import enums.TipoCurso;


public class CursoOnline extends Curso{
	private int numAcessos;
	
	  public CursoOnline(String id,String titulo, String descricao, int anoCriacao, int DuracaoHoras, double preco,TipoCurso tipo) {
	        super(id, titulo, descricao, anoCriacao, DuracaoHoras, preco, tipo);
	  }
	
	public int getNumeroAcessos() {
        return numAcessos;
    }
	 @Override
	    public void avaliarCurso() {
	        System.out.println("Avaliando curso online: " + getTitulo());
	    }

	@Override
	public int compareTo(Curso o) {
	
		return 0;
	}

}
