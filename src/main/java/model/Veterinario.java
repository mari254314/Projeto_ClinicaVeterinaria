package model;

public class Veterinario {
    
    private int id;
    private int tel;
    private String nome;
    private String end;
    
    //Construtor

    public Veterinario(int id, int tel, String nome, String end) {
        this.id = id;
        this.tel = tel;
        this.nome = nome;
        this.end = end;
    }
      
    //Getters e Setters

    public int getId() {
        return id;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
}
