package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TratamentoDAO {
    private List<Tratamento> tratamentos = new ArrayList<Tratamento>();
    private int id_tratamento = 1;

    public List<Tratamento> create(String data_fin, String data_ini, int id_animal, int id_consulta) {
        Tratamento tratamento = new Tratamento(id_tratamento, data_fin, data_ini, id_animal, id_consulta);
        this.tratamentos.add(tratamento);
        id_tratamento++;
        return this.tratamentos;
    }

    public List<Tratamento> retrieveAll() {
        return this.tratamentos;
    }

    public List<Tratamento> retrieveByID(int id) {
        return (List<Tratamento>) this.tratamentos.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String data_fin, String data_ini) {
        int index = 0;

        for (Tratamento tratamento:this.tratamentos) {
            if (tratamento.getId() == id) {
                Tratamento tratamento_update = this.tratamentos.get(index);
                tratamento_update.setData_fin(data_fin);
                tratamento_update.setData_ini(data_ini);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Tratamento tratamento:this.tratamentos) {
            if (tratamento.getId() == id) {
                this.tratamentos.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}
