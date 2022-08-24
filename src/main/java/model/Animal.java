package model;

public class Animal {
    
    private int id;
    private String sexo;
    private String nome;
    private int idade;
    private int id_especie;
    private int id_cliente;
    private int id_tratamento;
    
    //Construtor

    public Animal(int id, String sexo, String nome, int idade, int id_especie, int id_cliente, int id_tratamento) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
        this.id_especie = id_especie;
        this.id_cliente = id_cliente;
        this.id_tratamento = id_tratamento;
    }
    
    //Getters e Setters

    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId_especie() {
        return id_especie;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public int getId_tratamento() {
        return id_tratamento;
    }

}
