package lucasho;

import java.util.ArrayList;
import java.sql.*;

public class ConsultaDAO extends Conexao {

    public String create(Consulta consulta) {
        try {
            return this.atualizarBanco("INSERT INTO CONSULTA(IDMEDICO, IDPACIENTE, CONVENIO) VALUES ("
                    + Integer.toString(consulta.getIdMedico()) + ", "
                    + Integer.toString(consulta.getIdPaciente()) + ", '"
                    + consulta.getConvenio() + "')");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String update(Consulta consulta) {
        try {
            return this.atualizarBanco("UPDATE CONSULTA SET IDMEDICO = " + Integer.toString(consulta.getIdMedico())
                    + " , IDPACIENTE = " + Integer.toString(consulta.getIdPaciente())
                    + " , CONVENIO = '" + consulta.getConvenio()
                    + "' WHERE ID = " + Integer.toString(consulta.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String delete(int id) {
        try {
            return this.atualizarBanco("DELETE FROM CONSULTA WHERE ID = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList list() {
        try {
            ResultSet result = this.getResultSet("SELECT CONSULTA.ID, CONCAT(MEDICO.ID, \" - \", MEDICO.NOME) AS MEDICO, CONCAT(PACIENTE.ID, \" - \", PACIENTE.NOME) AS PACIENTE, CONVENIO FROM CONSULTA "
                    + " LEFT JOIN PACIENTE ON PACIENTE.ID = CONSULTA.IDPACIENTE "
                    + " LEFT JOIN MEDICO ON MEDICO.ID = CONSULTA.IDMEDICO ORDER BY CONVENIO");
            ArrayList list = new ArrayList();
            while (result.next()) {
                TableCellConsulta consulta = new TableCellConsulta();
                consulta.setId(result.getInt("id"));
                consulta.setMedico(result.getString("medico"));
                consulta.setPaciente(result.getString("paciente"));
                consulta.setConvenio(result.getString("convenio"));
                list.add(consulta);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
