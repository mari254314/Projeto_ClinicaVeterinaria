package model;

public class Consulta {
    
    private int id;
    private String data;
    private String descricao;
    private int id_veterinario;
    private int id_exame;
    
    //Construtor

    public Consulta(int id, String data, String descricao, int id_veterinario, int id_exame) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.id_veterinario = id_veterinario;
        this.id_exame = id_exame;
    }
    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public int getId_exame() {
        return id_exame;
    }
   
}    
  