package model;

public class Animal {
    private int id;
    private String nome;
    private int idade;
    private String sexo; // Macho, Femea
    private int id_especie;
    private int id_cliente;

    public Animal(int id, String nome, int idade, String sexo, int id_especie, int id_cliente) {
        this.id = id;
        this.sexo = sexo;
        this.nome = nome;
        this.idade = idade;
        this.id_especie = id_especie;
        this.id_cliente = id_cliente;
    }
    
    public int getId(){
        return id;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getId_especie() {
        return id_especie;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_especie(int id_especie) {
        this.id_especie = id_especie;
    }
      
    @Override
    public String toString() {
        return "Animal: " + "\nNome: " + nome + "\nIdade: " + idade + "\nSexo: " + sexo + "\nId da Espécie: " + id_especie + "\n\n";
    }
        
}
