package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExameDAO {
    private List<Exame> exames = new ArrayList<Exame>();
    private int id_exame = 1;

    public List<Exame> create(String descricao, int id_consulta) {
        Exame exame = new Exame(id_exame, descricao, id_consulta);
        this.exames.add(exame);
        id_exame++;
        return this.exames;
    }

    public List<Exame> retrieveAll() {
        return this.exames;
    }

    public List<Exame> retrieveByID(int id) {
        return (List<Exame>) this.exames.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String descricao) {
        int index = 0;

        for (Exame exame:this.exames) {
            if (exame.getId() == id) {
                Exame exame_update = this.exames.get(index);
                exame_update.setDescricao(descricao);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Exame exame:this.exames) {
            if (exame.getId() == id) {
                this.exames.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}