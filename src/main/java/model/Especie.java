package model;

public class Especie {
    
    private int id;
    private String nome;
    
    //Construtor
     public Especie(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
    
        @Override
    public String toString() {
        return "\nEspécie: \n" + "Id: " + id + "\nTipo da Espécie: " + nome + "\n";
    }

}
