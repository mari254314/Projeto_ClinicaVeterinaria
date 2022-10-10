package model;

public class Consulta {
    
    private int id;
    private String horario;
    private String data;
    private String comentario;
    private int id_veterinario;
    private int id_animal;
    private int id_tratamento;
    
    //Construtor

    public Consulta(int id, String horario, String data, String comentario, int id_veterinario, int id_animal, int id_tratamento) {
        this.id = id;
        this.horario = horario;
        this.data = data;
        this.comentario = comentario;
        this.id_veterinario = id_veterinario;
        this.id_animal = id_animal;
        this.id_tratamento = id_tratamento;
    }    
    //Getters and Setters

    public int getId() {
        return id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_veterinario() {
        return id_veterinario;
    }

    public int getId_animal() {
        return id_animal;
    }

    public int getId_tratamento() {
        return id_tratamento;
    }
    
    @Override
    public String toString() {
        return "Consulta: " + "\nHorário: " + horario + "\nData: " + data + "\nComentário: " + comentario 
                + "\nId do Veterinário: " + id_veterinario + "\nId do Animal: " + id_animal + "\nId do Tratamento: " + id_tratamento + "\n\n";
    }
}    
  