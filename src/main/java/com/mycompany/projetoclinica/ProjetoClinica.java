/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projetoclinica;

import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Tratamento;
import model.TratamentoDAO;


/** @author Mariana **/

public class ProjetoClinica {
    
    public static void main(String[] args) {    
        
        /****** Cliente ******/
                   
        //Criando um novo cliente
        
        //Cliente cli = ClienteDAO.getInstance().create("Cliente 15", "Endereco 15", "Telefone 15", "Cep 15", "Email 15");
        //System.out.println(ClienteDAO.getInstance().retrieveById(14));

        //Atualizando os clientes 

        //apenas um dado
        
          /*Cliente cli = ClienteDAO.getInstance().retrieveById(8);
          cli.setNome("José");
          ClienteDAO.getInstance().update(cli);
              
              System.out.println("Atualizado! \n");
              System.out.println(ClienteDAO.getInstance().retrieveAll());
              System.out.println(ClienteDAO.getInstance().retrieveById(8));*/
        
        //todos os dados
        
            /*Cliente cli = new Cliente(10, "Barbara", "Endereço da Barbara", "19974123586", "12345886", "barbara@gmail.com");
            ClienteDAO.getInstance().update(cli);
            System.out.println("Tudo atualizado! \n");
            System.out.println(ClienteDAO.getInstance().retrieveAll());*/

        //Deletando um cliente 
  
           /*Cliente cli = ClienteDAO.getInstance().retrieveById(9);
           ClienteDAO.getInstance().delete(cli);
            
                  System.out.println("Deletado! \n");
                  System.out.println(ClienteDAO.getInstance().retrieveAll());*/
            
        //Recuperar dados dos clientes - ById e All
        
          //  System.out.println("Mostrando todo os clientes cadastrados: \n");
          //  System.out.println(AnimalDAO.getInstance().retrieveAll());
           // System.out.println(AnimalDAO.getInstance().retrieveById(5));
            
/*****************************************************************************************************/

        /****** Animal ******/
                   
        //Criando um novo animal
        
        //Animal ani = AnimalDAO.getInstance().create("Animal do Cliente 15", 5, "Macho", 2, cli);
       // System.out.println(AnimalDAO.getInstance().retrieveById(14));

        //Atualizando os animais 

        //apenas um dado
        
          /*Animal ani = AnimalDAO.getInstance().retrieveById(2);
          ani.setNome("Abraão");
          AnimalDAO.getInstance().update(ani);
              
              System.out.println("Atualizado! \n");
              System.out.println(AnimalDAO.getInstance().retrieveAll());
              System.out.println(AnimalDAO.getInstance().retrieveById(2));*/
        
        //todos os dados
        
            /*Animal ani = new Animal(3, "Thor", 8, "Macho", 1, 2);
            AnimalDAO.getInstance().update(ani);
            System.out.println("Tudo atualizado! \n");
            System.out.println(AnimalDAO.getInstance().retrieveAll());*/

        //Deletando um animal 
  
           /*Animal ani = AnimalDAO.getInstance().retrieveById(3);
           AnimalDAO.getInstance().delete(ani);
            
                  System.out.println("Deletado! \n");
                  System.out.println(AnimalDAO.getInstance().retrieveAll());*/
            
        //Recuperar dados dos animais - ById e All
        
//            System.out.println("Mostrando todos os animais cadastrados: \n");
//            System.out.println(AnimalDAO.getInstance().retrieveAll());
           // System.out.println(AnimalDAO.getInstance().retrieveById(15));
            
                   
/*****************************************************************************************************/
     
        /****** Especie ******/
                   
        //Criando uma nova espécie
        
//           Especie especieX = EspecieDAO.getInstance().create("Tartaruga");
//           System.out.println(EspecieDAO.getInstance().retrieveAll());

        //Atualizando as especies 

//          Especie especies = EspecieDAO.getInstance().retrieveById(4);
//          especies.setNome("Passaro");
//          EspecieDAO.getInstance().update(especies);
                
//              System.out.println("Atualizado");
//              System.out.println(EspecieDAO.getInstance().retrieveAll());
//              System.out.println(EspecieDAO.getInstance().retrieveById(4));
            
            /*Especie esp = new Especie(3, "Gato");
            EspecieDAO.getInstance().update(esp);
            System.out.println("Tudo atualizado");
            System.out.println(EspecieDAO.getInstance().retrieveAll());*/

        //Deletando uma especie  
  
//            Especie especies = EspecieDAO.getInstance().retrieveById(4);
//            EspecieDAO.getInstance().delete(especies);
            
//                  System.out.println("Deletado");
//                  System.out.println(EspecieDAO.getInstance().retrieveAll());
            
        //Recuperar dados de especie - ById e All
        
//            System.out.println("Mostrando todos as espécies: ");
//            System.out.println(EspecieDAO.getInstance().retrieveAll());
//            System.out.println(EspecieDAO.getInstance().retrieveById(1));

/*****************************************************************************************************/

        /****** Veterinario ******/
                   
        //Criando um(a) novo(a) veterinario(a)
        
//         Veterinario vet = VeterinarioDAO.getInstance().create("Marcia Castro", "marciacastro@gmail.com", "19988886666");
//         System.out.println(VeterinarioDAO.getInstance().retrieveAll());

        //Atualizando os(as) veterinarios(as) 

        //apenas um dado
        
//          Veterinario vet = VeterinarioDAO.getInstance().retrieveById(2);
//          vet.setNome("Paula Castro");
//          VeterinarioDAO.getInstance().update(vet);
                
//              System.out.println("Atualizado! \n");
//              System.out.println(VeterinarioDAO.getInstance().retrieveAll());
//              System.out.println(VeterinarioDAO.getInstance().retrieveById(2));
        
        //todos os dados
        
            /*Veterinario vet = new Veterinario(1, "Caio Araújo", "caio@gmail.com", "19933337777");
            VeterinarioDAO.getInstance().update(vet);
            System.out.println("Tudo atualizado! \n");
            System.out.println(VeterinarioDAO.getInstance().retrieveAll());*/

        //Deletando um(a) veterinario(a) 
  
//          Veterinario vet = VeterinarioDAO.getInstance().retrieveById(2);
//           VeterinarioDAO.getInstance().delete(vet);
            
//                  System.out.println("Deletado! \n");
//                  System.out.println(VeterinarioDAO.getInstance().retrieveAll());
            
        //Recuperar dados de especie - ById e All
        
//            System.out.println("Mostrando todos os veterinários cadastrados: \n");
//            System.out.println(VeterinarioDAO.getInstance().retrieveAll());
//            System.out.println(VeterinarioDAO.getInstance().retrieveById(1));


/*****************************************************************************************************/

        /****** Tratamento ******/
                   
        //Criando um novo tratamento
        
//         Tratamento tra = TratamentoDAO.getInstance().create("Tratamento 3", "05/03/2022", "05/03/2022", "");
//         System.out.println(TratamentoDAO.getInstance().retrieveAll());

        //Atualizando os tratamentos 

        //apenas um dado
        
//          Tratamento tra = TratamentoDAO.getInstance().retrieveById(2);
//          tra.setNome("Tratamento 2: Câncer");
//          TratamentoDAO.getInstance().update(tra);
                
//              System.out.println("Atualizado! \n");
//              System.out.println(TratamentoDAO.getInstance().retrieveAll());
//              System.out.println(TratamentoDAO.getInstance().retrieveById(2));
        
        //todos os dados
        
            /*Tratamento tra = new Tratamento(3, "Tratamento 3: Pulgas", "05/03/2022", "05/03/2022", 2);
            TratamentoDAO.getInstance().update(tra);
            System.out.println("Tudo atualizado! \n");
            System.out.println(TratamentoDAO.getInstance().retrieveAll());*/

        //Deletando um tratamento 
  
//           Tratamento tra = TratamentoDAO.getInstance().retrieveById(1);
//           TratamentoDAO.getInstance().delete(tra);
            
//                  System.out.println("Deletado! \n");
//                  System.out.println(TratamentoDAO.getInstance().retrieveAll());
            
        //Recuperar dados dos tratamentos - ById e All
        
//            System.out.println("Mostrando todos os tratamentos cadastrados: \n");
//            System.out.println(TratamentoDAO.getInstance().retrieveAll());
//            System.out.println(TratamentoDAO.getInstance().retrieveById(2));

/*****************************************************************************************************/

        /****** Consulta ******/
                   
        //Criando uma nova consulta
        
         //Consulta con = ConsultaDAO.getInstance().create(20:00, "14/02/2022", "Deu tudo certo!", 0, 0, 0);
         System.out.println(ConsultaDAO.getInstance().retrieveAll());

        //Atualizando as consultas 

        //apenas um dado
        
          /*Consulta con = ConsultaDAO.getInstance().retrieveById(2);
          con.setComentario("O animal está muito bravo e a consulta não foi realizada");
          ConsultaDAO.getInstance().update(con);
              
              System.out.println("Atualizado! \n");
              System.out.println(ConsultaDAO.getInstance().retrieveAll());
              System.out.println(ConsultaDAO.getInstance().retrieveById(2));*/
        
        //todos os dados
        
            /*Consulta con = new Consulta(1, "14:00", "02/04/2022", "Deu tudo errado", 2 , 2, 2);
            ConsultaDAO.getInstance().update(con);
            System.out.println("Tudo atualizado! \n");
            System.out.println(ConsultaDAO.getInstance().retrieveAll());*/

        //Deletando uma consulta 
  
           /*Consulta con = ConsultaDAO.getInstance().retrieveById(1);
           ConsultaDAO.getInstance().delete(con);
            
                  System.out.println("Deletado! \n");
                  System.out.println(ConsultaDAO.getInstance().retrieveAll());*/
            
        //Recuperar dados das consultas - ById e All
        
            /*System.out.println("Mostrando todas as consultas cadastradas: \n");
            System.out.println(ConsultaDAO.getInstance().retrieveAll());
            System.out.println(ConsultaDAO.getInstance().retrieveById(2));*/
    
/*****************************************************************************************************/

        /****** Exame ******/
                   
        //Criando um novo exame
        
         /*Exame ex = ExameDAO.getInstance().create("Exame 3", 3);
         System.out.println(ExameDAO.getInstance().retrieveAll());*/

        //Atualizando os exames 

        //apenas um dado
        
          /*Exame ex = ExameDAO.getInstance().retrieveById(2);
          ex.setDescricao("Descrição passa a ser Exame xxx");
          ExameDAO.getInstance().update(ex);
              
              System.out.println("Atualizado! \n");
              System.out.println(ExameDAO.getInstance().retrieveAll());
              System.out.println(ExameDAO.getInstance().retrieveById(2));*/
        
        //todos os dados
        
//            Exame ex = new Exame(3,"Descrição passa a ser Exame yyy", 3);
//            ExameDAO.getInstance().update(ex);
//            System.out.println("Tudo atualizado! \n");
//            System.out.println(ExameDAO.getInstance().retrieveAll());

        //Deletando um exame 
  
           /*Exame ex = ExameDAO.getInstance().retrieveById(1);
           ExameDAO.getInstance().delete(ex);
            
                  System.out.println("Deletado! \n");
                  System.out.println(ExameDAO.getInstance().retrieveAll());*/
            
        //Recuperar dados dos exames - ById e All
        
            /*System.out.println("Mostrando todas os exames cadastrados: \n");
            System.out.println(ExameDAO.getInstance().retrieveAll());
            System.out.println(ExameDAO.getInstance().retrieveById(2));*/
            
    }
    
}