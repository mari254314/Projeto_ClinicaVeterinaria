package com.mycompany.projetoclinica;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;

public class ProjetoClinica{
    
    public static void main(String args[]) {
        
        ClienteDAO clienteDAO = new ClienteDAO();

    //Adicionando clientes -> CREATE

        clienteDAO.create("Nome1", "Endereço1", "email1@gmail.com", "11111-111", "1991111-1111", 1);
        clienteDAO.create("Nome2", "Endereço2", "email2@gmail.com", "22222-222", "1992222-2222", 2);
        clienteDAO.create("Nome3", "Endereço3", "email3@gmail.com", "33333-333", "1993333-3333", 3);

    // Listando todos os Clientes Adicionados -> RETRIEVE/READ (lendo)
        
        System.err.println("Lista de todos os Clientes:");

        for (Cliente cliente:clienteDAO.retrieveAll()) {
            System.out.println("Id: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEnd() + ", Email: " + cliente.getEmail() + ", Cep: " + cliente.getCep() + ", Telefone: " + cliente.getTel());
        }

    //Listando um Cliente Específico -> RETRIEVE/READ (lendo)
        
        System.out.println("\nListando um Cliente Especifico: ");

        for (Cliente cliente:clienteDAO.retrieveId(2)) {//listando os dados do cliente 2
            System.out.println("Id: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEnd() + ", Email: " + cliente.getEmail() + ", Cep: " + cliente.getCep() + ", Telefone: " + cliente.getTel());
        }

    //Atualizando um Cliente Específico -> UPDATE 
        
        System.out.println("\nAtualizando um Cliente Especifico:");

        clienteDAO.update(4, "Nome4", "Endereço4", "email4@gmail.com", "44444-444", "1994444-4444");

        for (Cliente cliente:clienteDAO.retrieveAll()) { //Verificar!! (arrumar)
            System.out.println("Id: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEnd() + ", Email: " + cliente.getEmail() + ", Cep: " + cliente.getCep() + ", Telefone: " + cliente.getTel());
        }

    //Deletando um Cliente Específico -> DELETE
        
        System.out.println("\nDeletando um Cliente Específico:");

        clienteDAO.delete(2);//deletando o Cliente 2

        for (Cliente cliente:clienteDAO.retrieveAll()) {
            System.out.println("Id: " + cliente.getId() + ", Nome: " + cliente.getNome() + ", Endereço: " + cliente.getEnd() + ", Email: " + cliente.getEmail() + ", Cep: " + cliente.getCep() + ", Telefone: " + cliente.getTel());//mostrando os clientes que ainda possuem
        }

        AnimalDAO animalDAO = new AnimalDAO();

    //Adicionando um Animal para o Cliente -> CREATE
                
        animalDAO.create("Macho", "Bira", 2, 1, 1, 1);//adicionado no Cliente 1 -> penúltimo numero
        animalDAO.create("Fêmea", "Bela", 3, 2, 1, 2);//adicionado no Cliente 1 -> penúltimo numero

    //Listando todos os animais do Cliente 2
        
        System.out.println("\nLista de todos os Animais do Cliente 1:");

        for (Animal animal:animalDAO.retrieveByClientID(1)) {
            System.out.println("Id: " + animal.getId() + ", Nome: " + animal.getNome()+ ", Sexo: " + animal.getSexo() + ", Id do Cleinte: " + animal.getId_cliente());
        }
    }
}