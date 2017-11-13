package br.projetos.sccc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.event.data.FilterEvent;

import br.projetos.sccc.dao.OcorrenciaDAO;
import br.projetos.sccc.pojo.EventoPOJO;
import br.projetos.sccc.pojo.OcorrenciaPOJO;

@ViewScoped
@ManagedBean(name = "ocorrencia")
public class OcorrenciaBEAN implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OcorrenciaPOJO ocorrenciaPOJO;
	private EventoPOJO eventoPOJO;
	private List<OcorrenciaPOJO> listaOcorrencia;
	
	
	
	public OcorrenciaBEAN(){
		
		setOcorrenciaPOJO(new OcorrenciaPOJO());
		
	}
	



	public EventoPOJO getEventoPOJO() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		this.eventoPOJO = (EventoPOJO) session.getAttribute("ID_EVENTO");
		

		return eventoPOJO;
		
	
	}

	public void setEventoPOJO(EventoPOJO eventoPOJO) {
		this.eventoPOJO = eventoPOJO;
	}

	public List<OcorrenciaPOJO> getListaOcorrencia() throws Exception {

		this.listaOcorrencia = new ArrayList<OcorrenciaPOJO>();

		OcorrenciaDAO dao = new OcorrenciaDAO();

		setListaOcorrencia(dao.pesquisarOcorrencia(this.getEventoPOJO()));

		return listaOcorrencia;
	}

	public void setListaOcorrencia(List<OcorrenciaPOJO> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}

	// Método para adicionar mensagens de validação

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	
	
	
	public void novo() {
		
		ocorrenciaPOJO = new OcorrenciaPOJO();
	
	}

	public OcorrenciaPOJO getOcorrenciaPOJO() {
		return ocorrenciaPOJO;
	}

	public void setOcorrenciaPOJO(OcorrenciaPOJO ocorrenciaPOJO) {
		this.ocorrenciaPOJO = ocorrenciaPOJO;
	}
	
	
	
	public void inserirOcorrencia() {
		
		System.out.println("Chegamos no inserir ocorrencia" + this.eventoPOJO.getId());

		ocorrenciaPOJO.setOcorrenciaEvento(this.eventoPOJO.getId());

			OcorrenciaDAO dao = new OcorrenciaDAO();

	
		String retorno = dao.inserir(ocorrenciaPOJO);
		

		addMessage(retorno);

	}
	
	
	
	public void alterarOcorrencia() {

		OcorrenciaDAO dao = new OcorrenciaDAO();

		String retorno = dao.alterarOcorrencia(this.ocorrenciaPOJO);

		this.ocorrenciaPOJO = new OcorrenciaPOJO();

		addMessage(retorno);
	
		
	}
	


}
