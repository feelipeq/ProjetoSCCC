package br.projetos.sccc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import br.projetos.sccc.dao.OcorrenciaDAO;
import br.projetos.sccc.pojo.EventoPOJO;
import br.projetos.sccc.pojo.OcorrenciaPOJO;

@ViewScoped
@ManagedBean(name = "ocorrencia")
public class OcorrenciaBEAN {

	private OcorrenciaPOJO ocorrenciaPOJO;
	private EventoPOJO eventoPOJO;
	private List<EventoPOJO> listaEvento;

	public OcorrenciaPOJO getOcorrenciaPOJO() {
		return ocorrenciaPOJO;
	}

	public void setOcorrenciaPOJO(OcorrenciaPOJO ocorrenciaPOJO) {
		this.ocorrenciaPOJO = ocorrenciaPOJO;
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

	public List<EventoPOJO> getListaEvento() {

		this.listaEvento = new ArrayList<EventoPOJO>();

		OcorrenciaDAO dao = new OcorrenciaDAO();

		setListaEvento(dao.pesquisarEvento(this.getEventoPOJO()));

		return listaEvento;
	}

	public void setListaEvento(List<EventoPOJO> listaEvento) {
		this.listaEvento = listaEvento;
	}

	// Método para adicionar mensagens de validação

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	
	
	
	
	public void novo() {
		
		ocorrenciaPOJO = new OcorrenciaPOJO();
	}

}
