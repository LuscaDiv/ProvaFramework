package lucasho;

import java.sql.*;
import java.util.*;

public class PacienteDAO extends Conexao {

    public String create(Paciente paciente) {
        try {
            return this.atualizarBanco("INSERT INTO PACIENTE(NOME, CPF, IDADE) VALUES ('"
                    + paciente.getNome() + "', '"
                    + paciente.getCpf() + "', "
                    + Integer.toString(paciente.getIdade()) + ")");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String update(Paciente paciente) {
        try {
            return this.atualizarBanco("UPDATE PACIENTE SET NOME = '" + paciente.getNome()
                    + "' , CPF = '" + paciente.getCpf()
                    + "' , IDADE = " + Integer.toString(paciente.getIdade())
                    + " WHERE ID = " + Integer.toString(paciente.getId()));
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public ArrayList list() {
        try {
            ResultSet resultado = this.getResultSet("SELECT * FROM PACIENTE ORDER BY NOME");
            ArrayList array = new ArrayList();
            while (resultado.next()) {
                Paciente pac = new Paciente();
                pac.setId(resultado.getInt("ID"));
                pac.setNome(resultado.getString("NOME"));
                pac.setCpf(resultado.getString("CPF"));
                pac.setIdade(resultado.getInt("IDADE"));
                array.add(pac);
            }
            return array;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public String remove(int id) {
        try {
            return this.atualizarBanco("DELETE FROM PACIENTE WHERE ID = " + Integer.toString(id));
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
