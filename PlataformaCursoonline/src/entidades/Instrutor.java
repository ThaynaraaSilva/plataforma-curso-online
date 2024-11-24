package entidades;

public class Instrutor {

	private String nome;
	private String areaDeEspecializacao;
	private int anosDeExperiencia;

	public Instrutor(int id, String nome, String areaDeEspecializacao, int anosDeExperiencia) {

		this.nome = nome;
		this.areaDeEspecializacao = areaDeEspecializacao;
		this.anosDeExperiencia = anosDeExperiencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaDeEspecializacao() {
		return areaDeEspecializacao;
	}

	public void setAreaDeEspecializacao(String areaDeEspecializacao) {
		this.areaDeEspecializacao = areaDeEspecializacao;
	}

	public int getAnosDeExperiencia() {
		return anosDeExperiencia;
	}

	public void setAnosDeExperiencia(int anosDeExperiencia) {
		this.anosDeExperiencia = anosDeExperiencia;
	}

}