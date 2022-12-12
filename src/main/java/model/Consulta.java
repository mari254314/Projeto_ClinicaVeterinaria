package model;

import java.util.Calendar;

public class Consulta {
    
    private int id;
   // private int horario;
    private Calendar data;
    private String comentario;
    private int id_veterinario;
    private int id_animal;
    private int id_tratamento;
    //private boolean terminou;
    
    //Construtor

    public Consulta(int id, Calendar data, String comentario, int id_veterinario, int id_animal, int id_tratamento) {
        this.id = id;
        //this.horario = horario;
        this.data = data;
        this.comentario = comentario;
        this.id_veterinario = id_veterinario;
        this.id_animal = id_animal;
        this.id_tratamento = id_tratamento;
//        this.terminou = terminou;
    }    
    //Getters and Setters

    public int getId() {
        return id;
    }
//
//    public int getHorario() {
//        return horario;
//    }
//
//    public void setHorario(int horario) {
//        this.horario = horario;
//    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
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

    public void setId_veterinario(int id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public int getId_tratamento() {
        return id_tratamento;
    }

    public void setId_tratamento(int id_tratamento) {
        this.id_tratamento = id_tratamento;
    }

    
//    @Override
//    public String toString() {
//        return "Consulta: " + "\nHorário: " + horario + "\nData: " + data + "\nComentário: " + comentario 
//                + "\nId do Veterinário: " + id_veterinario + "\nId do Animal: " + id_animal + "\nId do Tratamento: " + id_tratamento + "\n\n";
//    }

}