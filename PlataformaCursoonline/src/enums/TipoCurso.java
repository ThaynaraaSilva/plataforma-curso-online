package enums;



public enum TipoCurso {
	
	PRESENCIAL("Curso Presencial"), 
	ONLINE("Curso Online");

	private String descricao;

	TipoCurso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return this.getDescricao();
	}

	public static TipoCurso getEnum(String value) {
		if (value == null)
			throw new IllegalArgumentException();
		for (TipoCurso v : values())
			if (value.equalsIgnoreCase(v.getDescricao()))
				return v;
		throw new IllegalArgumentException();
	}
}
