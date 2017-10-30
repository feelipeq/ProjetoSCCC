package br.projetos.sccc.pojo;

public class OcorrenciaPOJO {
	
	
	private String ID;
	private String tipo;
	private String descricao;
	private String ocorrenciaEvento;
	
	
	
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}
	
	
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

	public String getOcorrenciaEvento() {
		return ocorrenciaEvento;
	}

	public void setOcorrenciaEvento(String ocorrenciaEvento) {
		this.ocorrenciaEvento = ocorrenciaEvento;
	}
	

}
