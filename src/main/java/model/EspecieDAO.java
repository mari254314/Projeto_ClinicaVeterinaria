package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EspecieDAO {
    private List<Especie> especies = new ArrayList<Especie>();
    private int id_especie= 1;

    public List<Especie> create(String nome) {
        Especie especie = new Especie(id_especie, nome);
        this.especies.add(especie);
        id_especie++;
        return this.especies;
    }

    public List<Especie> retrieveAll() {
        return this.especies;
    }

    public List<Especie> retrieveByID(int id) {
        return (List<Especie>) this.especies.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, String nome) {
        int index = 0;

        for (Especie especie:this.especies) {
            if (especie.getId() == id) {
                Especie especie_update = this.especies.get(index);
                especie_update.setNome(nome);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Especie especie:this.especies) {
            if (especie.getId() == id) {
                this.especies.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}

