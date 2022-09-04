package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalDAO {
    private List<Animal> animais = new ArrayList<Animal>();
    private int id_animal = 1;

    public List<Animal> create(String sexo, String nome, int idade,  int id_especie, int id_cliente, int id_tratamento) {
        Animal animal = new Animal(id_animal, sexo, nome, idade, id_especie, id_cliente, id_tratamento);
        this.animais.add(animal);
        id_animal++;
        return this.animais;
    }

    public List<Animal> retrieveAll() {
        return this.animais;
    }

    public List<Animal> retrieveByID(int id) {
        return (List<Animal>) this.animais.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
    }

    public List<Animal> retrieveByClientID(int id) {
        return (List<Animal>) this.animais.stream().filter(item -> item.getId_cliente()== id).collect(Collectors.toList());
    }

    public int update(int id, String sexo, String nome, int idade,  int id_especie, int id_cliente, int id_tratamento) {
        int index = 0;

        for (Animal animal:this.animais) {
            if (animal.getId() == id) {
                Animal animal_update = this.animais.get(index);
                animal_update.setNome(nome);
                animal_update.setIdade(idade);
                animal_update.setSexo(sexo);
                break;
            }
            index++;
        }

        return 1;
    }

    public int delete(int id) {
        int index = 0;

        for (Animal animal:this.animais) {
            if (animal.getId() == id) {
                this.animais.remove(index);
                break;
            }
            index++;
        }

        return 1;
    }
}