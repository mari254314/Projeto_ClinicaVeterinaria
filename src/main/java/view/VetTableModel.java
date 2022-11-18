/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Veterinario;
import model.VeterinarioDAO;

/**
 *
 * @author maria
 */
public class VetTableModel  extends GenericTableModel {
    
    public VetTableModel (List vDados){
        super(vDados, new String[]{"Nome","Email","Telefone"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario vet = (Veterinario)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return vet.getNome();
            case 1:
                return vet.getEmail();
            case 2:
                return vet.getTelefone();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Veterinario vet = (Veterinario)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                vet.setNome((String)aValue);
                break;
            case 1:
                vet.setEmail((String)aValue);
                break;
            case 2:
                vet.setTelefone((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          VeterinarioDAO.getInstance().update(vet);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    
}
