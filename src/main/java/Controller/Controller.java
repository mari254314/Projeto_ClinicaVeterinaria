/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
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
import model.Exame;
import model.ExameDAO;
import model.Tratamento;
import model.TratamentoDAO;
import model.Veterinario;
import model.VeterinarioDAO;
import view.AnimalTableModel;
import view.ClienteTableModel;
//import view.ConsultaTableModel;
import view.EspecieTableModel;
import view.ExameTableModel;
import view.GenericTableModel;
import view.TratamentoTableModel;
import view.VetTableModel;

/**
 *
 * @author maria
 */
public class Controller {
    
    private static Cliente clienteSelecionado = null;
    private static Animal animalSelecionado= null;
    private static Veterinario vetSelecionado= null;
    private static Tratamento tratamentoSelecionado = null;
    
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
    
     public static Tratamento getTratamentoSelecionado(){
        return tratamentoSelecionado;
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

    //Botão Novo = atualiza Botão Novo
    public static boolean novosDados(JTable table){
         if(table.getModel() instanceof ClienteTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaCliente());
        }else if(table.getModel() instanceof AnimalTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaAnimais());
        }else if(table.getModel() instanceof VetTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaVets());
        }else if(table.getModel() instanceof EspecieTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaEspecies());
        }else if(table.getModel() instanceof TratamentoTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaTratamentos());
        }else if (table.getModel() instanceof ExameTableModel){
            ((GenericTableModel)table.getModel()).addItem(adicionaExames());
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
    
    /*******Consultas********/
    
    public static List getTodasConsultas(){
        return ConsultaDAO.getInstance().retrieveAll();
    }
    
//    public static Consulta adicionarConsultas(){
//        return ConsultaDAO.getInstance().create(0, Calendar.getInstance(), "", vetSelecionado.getId(), animalSelecionado.getId(), 0);
//    }
//    
//    public static boolean apagaConsulta(JTable table){
//        if (table.getSelectedRow() >= 0){
//            Object item = ((GenericTableModel)table.getModel()).getItem(table.getSelectedRow());
//            ((GenericTableModel)table.getModel()).removeItem(table.getSelectedRow());
//            ConsultaDAO.getInstance().delete((Consulta)item);
//            return true;
//        }return false;
//    }
//    
    
    
//    public static void filtraConsultas(JTable table, JComboBox jcTodas, JComboBox jcHoje, JComboBox jcVet) {//mais coisas aqui!!!!!!!!!1
//        if(table.getModel() instanceof ConsultaTableModel){
//            String where = "";
//            if(!jcTodas.isSelected()){
//                where = "WHERE data >= date('now')";
//            }
//            
//            String query = "SELEECT * FROM consulta"+where+"ORDER BY data, horario";
//            ((GenericTableModel) table.getModel()).addListOfItems(ConsultaDAO.getInstance().retrieve(query));
//        }
//    }
//    
    /*Tratamento*/
    
     //Botão Apaga = Tratamento
    public static void apagaTratamento(Tratamento tratamento){
        TratamentoDAO.getInstance().delete(tratamento);
    }   
    
    //Create novos tratamentos
    public static Tratamento adicionaTratamentos(){
        return TratamentoDAO.getInstance().create("", "", "", "");
    }
    
    public static List getTodosTratamentos(){
        return TratamentoDAO.getInstance().retrieveAll();
    }
    
    /********* Exame *********/
    
    public static List getTodosExames(){
        return ExameDAO.getInstance().retrieveAll();
    }
    
 //Create novos tratamentos
    public static Exame adicionaExames(){
        return ExameDAO.getInstance().create("",0);
    }

}

