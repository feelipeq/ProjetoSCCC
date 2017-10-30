package br.projetos.sccc.dao;

import java.util.ArrayList;
import java.util.List;

import br.projetos.sccc.pojo.EventoPOJO;
import br.projetos.sccc.pojo.OcorrenciaPOJO;

public class OcorrenciaDAO extends DAO {

	public List<OcorrenciaPOJO> pesquisarOcorrencia(EventoPOJO eventoPOJO) throws Exception {
	
		List<OcorrenciaPOJO> listaOcorrencia = new ArrayList<OcorrenciaPOJO>();
		
		try {

			abreConexao();
			st = cn.prepareStatement("SELECT * FROM tb_ocorrencia WHERE ocorrenciaEvento = ?");
			st.setInt(1, eventoPOJO.getId());
			rs = st.executeQuery();
			while (rs.next()) {

				OcorrenciaPOJO ocorrencia = new OcorrenciaPOJO();

				ocorrencia.setID(rs.getString("id"));
				ocorrencia.setDescricao(rs.getString("descricao"));
				ocorrencia.setTipo(rs.getString("tipo"));
				ocorrencia.setOcorrenciaEvento(rs.getString("ocorrenciaEvento"));

				listaOcorrencia.add(ocorrencia);
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

		finally {

			fecharConexao();
		}

		return listaOcorrencia;
	}

	}
	
	



