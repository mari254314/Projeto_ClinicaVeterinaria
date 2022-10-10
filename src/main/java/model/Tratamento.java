
package model;

public class Tratamento {
    
    private int id;
    private String nome;
    private String dataFim;
    private String dataIni;
    private int id_animal;
    
    //Construtor

    public Tratamento(int id, String nome, String dataFim, String dataIni, int id_animal) {
        this.id = id;
        this.nome = nome;
        this.dataFim = dataFim;
        this.dataIni = dataIni;
        this.id_animal = id_animal;
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

    public int getId_animal() {
        return id_animal;
    }
            @Override
    public String toString() {
        return "Tratamento: " + "\nNome: " + nome + "\nData Inicial: " + dataIni + "\nData Final: " + dataFim + "\n\n";
    }
}
