package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VeterinarioDAO {
    private List<Veterinario> veterinarios = new ArrayList<Veterinario>();
    private int id_veterinario = 1;

    public List<Veterinario> create(int tel, String nome, String end) {
        Veterinario veterinario = new Veterinario(id_veterinario, tel, nome, end);
        this.veterinarios.add(veterinario);
        id_veterinario++;
        return this.veterinarios;
    }

    public List<Veterinario> retrieveAll() {
        return this.veterinarios;
    }

    public List<Veterinario> retrieveByID(int id) {
        return (List<Veterinario>) this.veterinarios.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public int update(int id, int tel, String nome, String end) {
        int index = 0;

        for (Veterinario veterinario:this.veterinarios) {
            if (veterinario.getId() == id) {
                Veterinario veterinario_update = this.veterinarios.get(index);
                veterinario_update.setTel(tel);
                veterinario_update.setNome(nome);
                veterinario_update.setEnd(end);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Veterinario veterinario:this.veterinarios) {
            if (veterinario.getId() == id) {
                this.veterinarios.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}