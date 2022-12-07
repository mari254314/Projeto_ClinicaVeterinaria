
package model;

public class Tratamento {
    
    private int id;
    private String nome;
    private String dataFim;
    private String dataIni;
    private String animal;
    
    //Construtor

    public Tratamento(int id, String nome, String dataFim, String dataIni, String animal) {
        this.id = id;
        this.nome = nome;
        this.dataFim = dataFim;
        this.dataIni = dataIni;
        this.animal = animal;
    }
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getDataIni() {
        return dataIni;
    }

    public void setDataIni(String dataIni) {
        this.dataIni = dataIni;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
            @Override
    public String toString() {
        return "Tratamento: " + "\nNome: " + nome + "\nData Inicial: " + dataIni + "\nData Final: " + dataFim + "\n\n";
    }
}
