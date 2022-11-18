/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.Especie;
import model.EspecieDAO;
import model.Veterinario;
import model.VeterinarioDAO;
import view.AnimalTableModel;
import view.ClienteTableModel;
import view.ConsultaTableModel;
import view.EspecieTableModel;
import view.GenericTableModel;
import view.VetTableModel;

/**
 *
 * @author maria
 */
public class Controller {
    
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado= null;
    private static Veterinario vetSelecionado= null;
    
    private static JTextField clienteSelecionadoTextField = null;
    private static JTextField animalSelecionadoTextField = null;
    private static JTextField vetSelecionadoTextField = null;

    
     public static void setTextFields(JTextField cliente, JTextField animal, JTextField veterinario){
        clienteSelecionadoTextField = cliente;
        animalSelecionadoTextField = animal;
        vetSelecionadoTextField = veterinario;
    }
     
    public static void setTableModel(JTable table, GenericTableModel tableModel){
        table.setModel(tableModel);
    }
    
    public static Cliente getClienteSelecionado(){
        return clienteSelecionado;
    }
    
    public static Animal getAnimalSelecionado(){
        return animalSelecionado;
    }
    
    public static Veterinario getVetSelecionado(){
        return vetSelecionado;
    }
    
    public static void setSelected(Object selected){
        
        if(selected instanceof Cliente){
            clienteSelecionado = (Cliente)selected;
            clienteSelecionadoTextField.setText(clienteSelecionado.getNome());
            animalSelecionadoTextField.setText("");
        }else if(selected instanceof Animal){
            animalSelecionado = (Animal)selected;
            animalSelecionadoTextField.setText(animalSelecionado.getNome());
        }else if(selected instanceof Veterinario){
            vetSelecionado = (Veterinario) selected;
            vetSelecionadoTextField.setText(vetSelecionado.getNome());
        }
        
    }
    
    //Seleção dos Buttons
    public static void jRadioButtonClientesSelecionados(JTable table){
        setTableModel(table, new ClienteTableModel(ClienteDAO.getInstance().retrieveAll()));
    }
    
    public static boolean jRadioButtonAnimaisSelecionados(JTable table){
        if(Controller.getClienteSelecionado() != null){
            setTableModel(table, new AnimalTableModel(AnimalDAO.getInstance().retrieveByIdCliente(Controller.getClienteSelecionado().getId())));
            return true;
        }else{
            setTableModel(table, new AnimalTableModel(new ArrayList()));
            return false;
        }
    }
    
    public static void jRadioButtonEspeciesSelecionadas(JTable table){
        setTableModel(table, new EspecieTableModel(EspecieDAO.getInstance().retrieveAll()));
    }
    
    public static void jRadioButtonVetsSelecionados(JTable table){
        setTableModel(table, new VetTableModel(VeterinarioDAO.getInstance().retrieveAll()));
    }
    
    public static void atualizaNomeParecido(JTable table, String nomeParecido){
        if(table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }else if(table.getModel() instanceof VetTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }else if(table.getModel() instanceof AnimalTableModel){
            if(getClienteSelecionado()!= null){
                ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveBySimilarName(getClienteSelecionado().getId(), nomeParecido));
               }        
        }else if(table.getModel() instanceof EspecieTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveBySimilarName(nomeParecido));
        }
    }
    
    //Botão todos - recuperando e mostrando todos os dados e limpando campo de texto
    public static void atualizaBotaoTodos(JTable table, JTextField textField){
        if(table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(ClienteDAO.getInstance().retrieveAll());                  
        }else if(table.getModel() instanceof VetTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(VeterinarioDAO.getInstance().retrieveAll());
        }else if(table.getModel() instanceof AnimalTableModel){
            if(getClienteSelecionado() != null){
                ((GenericTableModel)table.getModel()).addListOfItems(AnimalDAO.getInstance().retrieveByIdCliente(getClienteSelecionado().getId()));
            }
        }else if(table.getModel() instanceof EspecieTableModel){
            ((GenericTableModel)table.getModel()).addListOfItems(EspecieDAO.getInstance().retrieveAll());
        }
        textField.setText("");
        clienteSelecionadoTextField.setText("");
        clienteSelecionado=null;
    }    
    
    //Create novos clientes
    public static Cliente adicionaCliente(){
        return ClienteDAO.getInstance().create("", "", "", "", "");
    }
    
    //Create novos veterinarios
     public static Veterinario adicionaVets(){
        return VeterinarioDAO.getInstance().create("", "", "");
    }
     
    //Create novas especies
    public static Especie adicionaEspecies(){
        return EspecieDAO.getInstance().create("");
    }
    
    //Create novos animais
    public static Animal adicionaAnimais(){
        return AnimalDAO.getInstance().create("", 0,"", 0, clienteSelecionado);
    }
    
    //Create novas consultas
    public static Consulta adicionaConsultas(){
        return ConsultaDAO.getInstance().create(0, Calendar.getInstance() ,"", 0, 0, 0, true);
    }
    
    //Botão Novo = atualiza Botão Novo
    public static boolean novosDados(JTable table){
         if(table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addItem(Controller.adicionaCliente());
        }else if(table.getModel() instanceof AnimalTableModel){
            ((GenericTableModel)table.getModel()).addItem(Controller.adicionaAnimais());
        }else if(table.getModel() instanceof VetTableModel){
            ((GenericTableModel)table.getModel()).addItem(Controller.adicionaVets());
        }else if(table.getModel() instanceof EspecieTableModel){
            ((GenericTableModel)table.getModel()).addItem(Controller.adicionaEspecies());
        }else if(table.getModel() instanceof ConsultaTableModel){
              if((clienteSelecionado!=null)&&(animalSelecionado!=null)&&(vetSelecionado!=null)){
                ((GenericTableModel)table.getModel()).addItem(Controller.adicionaConsultas());
              }else{
                  return false;
              }
        }
         return true;
    }
    
    //Botão Apaga = Cliente
    public static void apagaCliente(Cliente cliente){
        List<Animal> animais = AnimalDAO.getInstance().retrieveByIdCliente(cliente.getId());
        for(Animal animal : animais){
            AnimalDAO.getInstance().delete(animal);
        }
        ClienteDAO.getInstance().delete(cliente);
    }
    
     //Botão Apaga = Animal
    public static void apagaAnimal(Animal animal){
        AnimalDAO.getInstance().delete(animal);
        animalSelecionadoTextField.setText("");
        animalSelecionado=null;
    }
    
    //Botão Apaga = Veterinário
    public static void apagaVet(Veterinario veterinario){
        VeterinarioDAO.getInstance().delete(veterinario);
        vetSelecionadoTextField.setText("");
        vetSelecionado=null;

    }
    
}
