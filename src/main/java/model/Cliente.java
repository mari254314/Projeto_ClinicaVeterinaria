/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/** @author Mariana **/

public class Cliente {
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String cep;
    private String email;
    
    //private List<Animal> animais;

    public Cliente(int id, String nome, String endereco, String telefone, String cep, String email) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.email = email;
        //this.animais = new ArrayList<Animal>();
    }
    
    public int getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

   /* public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }  
    
    public void setEmail(String email){
        if(!email.equals("")){
            this.email = email;
        }
    }

    public boolean addAnimal(Animal animal){
        if(!animal.getNome().isBlank()){
            animais.add(animal);
            return true;
        }
        return false;
    }
    
    public List<Animal> getAnimais(){
        List<Animal> copia = new ArrayList<Animal>(animais);        
        return copia;
    }*/
    
    @Override
    public String toString() {        
        String desc = "Cliente:" + "\nId: " + id + "\nNome: " + nome + "\nEndereco=: " + endereco + "\nTelefone:" 
                + telefone + "\nCep: " + cep + "\nEmail: " + email + "\n\n";
       // String strAnimais = animais.toString();
       return desc + "\n";
       //return desc + "\n" + strAnimais;
    }    
}
