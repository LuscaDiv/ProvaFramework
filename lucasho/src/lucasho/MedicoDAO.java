package lucasho;

import java.util.ArrayList;
import java.sql.*;

public class MedicoDAO extends Conexao {

    public String create(Medico medico) {
        try {
            return this.atualizarBanco("INSERT INTO MEDICO(NOME, ESPECIALIDADE, CRM, CPF) VALUES ('"
                    + medico.getNome() + "', "
                    + Integer.toString(medico.getEspecialidade()) + ", "
                    + Integer.toString(medico.getCrm()) + ", '"
                    + medico.getCpf() + "')");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String update(Medico medico) {
        try {
            return this.atualizarBanco("UPDATE MEDICO SET NOME = '" + medico.getNome()
                    + "' , ESPECIALIDADE = " + Integer.toString(medico.getEspecialidade())
                    + " , CRM = " + Integer.toString(medico.getCrm())
                    + " , CPF = '" + medico.getCpf()
                    + "' WHERE ID = " + Integer.toString(medico.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String delete(int id) {
        try {
            return this.atualizarBanco("DELETE FROM MEDICO WHERE ID = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList list() {
        try {
            ResultSet result = this.getResultSet("SELECT * FROM MEDICO ORDER BY NOME");
            ArrayList list = new ArrayList();
            while (result.next()) {
                Medico med = new Medico();
                med.setId(result.getInt("ID"));
                med.setNome(result.getString("NOME"));
                med.setEspecialidade(result.getInt("ESPECIALIDADE"));
                med.setCrm(result.getInt("CRM"));
                med.setCpf(result.getString("CPF"));
                list.add(med);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
