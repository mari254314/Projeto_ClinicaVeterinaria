
package model;

public class Tratamento {
    
    private int id;
    private String data_fin;
    private String data_ini;
    private int id_animal;
    private int id_consulta;
    
    //Construtor

    public Tratamento(int id, String data_fin, String data_ini, int id_animal, int id_consulta) {
        this.id = id;
        this.data_fin = data_fin;
        this.data_ini = data_ini;
        this.id_animal = id_animal;
        this.id_consulta = id_consulta;
    }
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getData_fin() {
        return data_fin;
    }

    public void setData_fin(String data_fin) {
        this.data_fin = data_fin;
    }

    public String getData_ini() {
        return data_ini;
    }

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public int getId_animal() {
        return id_animal;
    }

    public int getId_consulta() {
        return id_consulta;
    }   
}
