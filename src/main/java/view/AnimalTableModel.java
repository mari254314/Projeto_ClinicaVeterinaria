/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Animal;
import model.Especie;
import model.AnimalDAO;
import model.EspecieDAO;

/**
 *
 * @author maria
 */
public class AnimalTableModel extends GenericTableModel {
    
    public AnimalTableModel (List vDados){
        super(vDados, new String[]{"Nome","Idade","Sexo","Especie"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return animal.getNome();
            case 1:
                return animal.getIdade();
            case 2:
                return animal.getSexo();
            case 3:
                Especie species = EspecieDAO.getInstance().retrieveById(animal.getId_especie());
                if(species != null){
                    return species.getNome();
                }
                    return "";
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Animal animal = (Animal)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                animal.setNome((String)aValue);
                break;
            case 1:
                animal.setIdade((Integer)aValue);
                break;
            case 2:
                animal.setSexo((String)aValue);
                break;
            case 3:
                Especie species = EspecieDAO.getInstance().retrieveByName(animal.getNome());    
                if(species != null){
                    species = EspecieDAO.getInstance().create((String)aValue);
                }
                animal.setId_especie(species.getId());
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          AnimalDAO.getInstance().update(animal);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    
}

