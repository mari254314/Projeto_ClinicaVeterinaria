package model;

public class Cliente {
    
    private int id;
    private String nome;
    private String end;
    private String email;
    private int cep;
    private int tel;
    private int id_animal;

    //Construtor
    
    public Cliente(int id, String nome, String end, String email, int cep, int tel, int id_animal) {
        this.id = id;
        this.nome = nome;
        this.end = end;
        this.email = email;
        this.cep = cep;
        this.tel = tel;
        this.id_animal= id_animal;
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

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getId_animal() {
        return id_animal;
    }

}