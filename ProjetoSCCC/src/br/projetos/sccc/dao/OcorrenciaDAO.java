package br.projetos.sccc.dao;

import java.util.ArrayList;
import java.util.List;


import br.projetos.sccc.pojo.EventoPOJO;

public class OcorrenciaDAO extends DAO {

	public List<EventoPOJO> pesquisarEvento(EventoPOJO eventoPOJO) {
	
		List<EventoPOJO> listaEvento = new ArrayList<EventoPOJO>();
		
		try {

			abreConexao();
			st = cn.prepareStatement("SELECT * FROM tb_ocorrencia WHERE CENARIOPROJETO = ?");
			st.setString(1, evento.getPsi());
			rs = st.executeQuery();
			while (rs.next()) {

				CenarioPOJO cenario = new CenarioPOJO();

				cenario.setId((Integer) rs.getInt("id"));
				cenario.setDescricao(rs.getString("descricao"));
				cenario.setResultadoEsperado(rs.getString("resultadoesperado"));
				cenario.setObservacao(rs.getString("observacao"));
				cenario.setDataRealizacao(rs.getDate("datarealizacao"));
				cenario.setStatus(rs.getString("status"));
				cenario.setCenarioProjeto(rs.getString("cenarioprojeto"));
				cenario.setTempo(rs.getInt("tempo"));

				listaCen.add(cenario);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		finally {

			fecharConexao();
		}

		return listaCen;
	}
		
		return null;
	}
	
	


}
