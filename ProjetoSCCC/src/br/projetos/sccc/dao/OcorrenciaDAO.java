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

				ocorrencia.setID(rs.getInt("id"));
				ocorrencia.setDescricao(rs.getString("descricao"));
				ocorrencia.setTipo(rs.getString("tipo"));
				ocorrencia.setOcorrenciaEvento(rs.getInt("ocorrenciaEvento"));

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

	public String inserir(OcorrenciaPOJO ocorrenciaPOJO) {
		
		
				String retorno = "Ocorrência " + ocorrenciaPOJO.getID()
		+ " inserido com sucesso!";
try {

	abreConexao();
	st = cn.prepareStatement("INSERT INTO tb_ocorrencia (id, tipo, ocorrenciaEvento, descricao) VALUES (?,?,?,?)");
	st.setInt(1, ocorrenciaPOJO.getID());
	st.setString(2, ocorrenciaPOJO.getTipo());
	st.setInt(3, ocorrenciaPOJO.getOcorrenciaEvento());

	st.setString(4, ocorrenciaPOJO.getDescricao());

	
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

System.out.println(retorno);

return retorno;


	}
	
	
	
	
	
	public String alterarOcorrencia(OcorrenciaPOJO ocorrencia) {

		String retorno = "Ocorrência: " +" " + ocorrencia.getID()+ " "+ " atualizado com sucesso!";
	

		try {

			abreConexao();
			st = cn.prepareStatement("UPDATE tb_ocorrencia SET ID = ?, tipo = ?, descricao = ? WHERE ocorrenciaEvento = ? ");
			st.setInt(1, ocorrencia.getID());
			st.setString(2, ocorrencia.getTipo());
			st.setString(3, ocorrencia.getDescricao());
						
			st.setInt(4, ocorrencia.getOcorrenciaEvento());

			st.execute();
			
			System.out.println("Ocorrencia do Evento" + ocorrencia.getOcorrenciaEvento());

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

	}
	
	



