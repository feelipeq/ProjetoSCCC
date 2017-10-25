package br.projetos.sccc.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import br.projetos.sccc.dao.EventoDAO;
import br.projetos.sccc.pojo.EventoPOJO;

@ViewScoped
@ManagedBean(name = "evento")
public class EventoBEAN {
	
	
	private EventoPOJO eventoPOJO;
	private List<EventoPOJO> listaEvento;
	
	
	public EventoBEAN() {
		
		
		setEventoPOJO(new EventoPOJO());
	}
	
	
	
	public EventoPOJO getEventoPOJO() {
		return eventoPOJO;
	}
	
	
	public void setEventoPOJO(EventoPOJO eventoPOJO) {
		this.eventoPOJO = eventoPOJO;
	}
	
	
	public List<EventoPOJO> getListaEvento() {
		
		this.listaEvento = new ArrayList<EventoPOJO>();
		
		EventoDAO dao = new EventoDAO();
		
		try {

			setListaEvento(dao.pesquisarEvento());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return listaEvento;
	}
	
	
	
	public void setListaEvento(List<EventoPOJO> listaEvento) {
		this.listaEvento = listaEvento;
	
	
	}
	
	
	
	public void novo() {
		
		eventoPOJO = new EventoPOJO();
		
		
	}

	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
	public void inserirEvento() {

		EventoDAO dao = new EventoDAO();

		String retorno = dao.inserirEvento(eventoPOJO);

		eventoPOJO = new EventoPOJO();

		addMessage(retorno);

	}
	
	public void alterarEvento() {

		EventoDAO dao = new EventoDAO();

		String retorno = dao.alterarEvento(eventoPOJO);

		eventoPOJO = new EventoPOJO();

		addMessage(retorno);

	}
	
	public void deletarEvento() {

		EventoDAO dao = new EventoDAO();

		String retorno = dao.deletarEvento(eventoPOJO);

		eventoPOJO = new EventoPOJO();

		addMessage(retorno);

	}
	
	
	
	public void limparTudo() {

       this.eventoPOJO.setTecnologia(null);
       this.eventoPOJO.setAmbiente(null);
       this.eventoPOJO.setDescricao(null);
       this.eventoPOJO.setEquipe(null);
       this.eventoPOJO.setContato(null);
       this.eventoPOJO.setDataAbertura(null);
       this.eventoPOJO.setStatus(null);
	}
	

}
