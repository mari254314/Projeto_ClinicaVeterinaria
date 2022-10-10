package model;

public class Exame {
    
    private int id;
    private String descricao;
    private int id_consulta;
    
    //Construtor

    public Exame(int id, String descricao, int id_consulta) {
        this.id = id;
        this.descricao = descricao;
        this.id_consulta = id_consulta;
    }
   
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }
  
            @Override
    public String toString() {
        return "Exame: " + "\nExame n° " + id + "\nDescrição: " + descricao + "\n\n";
    }
}

   
