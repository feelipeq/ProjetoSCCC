package br.projetos.sccc.pojo;

public class OcorrenciaPOJO {
	
	
	private Integer ID;
	private String tipo;
	private String descricao;
	private Integer ocorrenciaEvento;
	
	
	
	

	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getOcorrenciaEvento() {
		return ocorrenciaEvento;
	}

	public void setOcorrenciaEvento(Integer ocorrenciaEvento) {
		this.ocorrenciaEvento = ocorrenciaEvento;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}


}
