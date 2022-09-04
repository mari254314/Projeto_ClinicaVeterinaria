package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaDAO {
 
    private List<Consulta> consulta = new ArrayList<Consulta>();
    private int id_consulta = 1;

    public List<Consulta> create(int id, String data, String descricao, int id_veterinario, int id_exame) {
        Consulta consulta = new Consulta(id_consulta, data, descricao, id_veterinario, id_exame);
        this.consulta.add(consulta);
        id_consulta++;
        return this.consulta;
    }

    public List<Consulta> retrieveAll() {
        return this.consulta;
    }

    public List<Consulta> retrieveByID(int id) {
        return (List<Consulta>) this.consulta.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String data, String descricao) {
        int index = 0;

        for (Consulta consulta:this.consulta) {
            if (consulta.getId() == id) {
                Consulta consulta_update = this.consulta.get(index);
                consulta_update.setData(data);
                consulta_update.setDescricao(descricao);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Consulta consulta:this.consulta) {
            if (consulta.getId() == id) {
                this.consulta.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }   
}
