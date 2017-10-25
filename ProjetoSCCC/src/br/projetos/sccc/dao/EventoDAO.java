package br.projetos.sccc.dao;

import java.util.ArrayList;
import java.util.List;
import br.projetos.sccc.pojo.EventoPOJO;





public class EventoDAO extends DAO {
	
	
	
	public String inserir(EventoPOJO evento) {

		String retorno = "Evento: " +" " + evento.getTecnologia()+ " "+ " inserido com sucesso!";
	

		try {

			abreConexao();
			st = cn.prepareStatement("INSERT INTO tb_evento (tecnologia, ambiente, descricao, equipe, contato, dataabertura, status) VALUES (?,?,?,?,?,?,?)");
			st.setString(1, evento.getTecnologia());
			st.setString(2, evento.getAmbiente());
			st.setString(3, evento.getDescricao());
			st.setString(4, evento.getEquipe());
			st.setString(5, evento.getContato());

			java.sql.Date dataabertura = new java.sql.Date(evento.getDataAbertura().getTime());

			st.setDate(6, dataabertura);

			st.setString(7, evento.getStatus());

			st.execute();

		} catch (Exception e) {

			retorno = e.getMessage();

		} finally {

			try {
				fecharConexao();
			} catch (Exception e) {

				retorno = e.getMessage();
			}
		}

		return retorno;

	}

	

	public List<EventoPOJO> pesquisarEvento() throws Exception {
	
		List<EventoPOJO> listaEvento = new ArrayList<EventoPOJO>();
		
		
		
		try {
			
			abreConexao();
			st = cn.prepareStatement("SELECT * FROM tb_evento");
			rs = st.executeQuery();
			while (rs.next()) {

				
				EventoPOJO evento = new EventoPOJO();
				
				evento.setId(rs.getInt("idtb_evento"));
				evento.setTecnologia(rs.getString("tecnologia"));
				evento.setAmbiente(rs.getString("ambiente"));
				evento.setDescricao(rs.getString("descricao"));
				evento.setEquipe(rs.getString("equipe"));
				evento.setContato(rs.getString("contato"));
				evento.setDataAbertura(rs.getDate("dataabertura"));
				evento.setStatus(rs.getString("status"));
				
				listaEvento.add(evento);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	finally {
			
			fecharConexao();
		}
			
			return listaEvento;

	}

}
