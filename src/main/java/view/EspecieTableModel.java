/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Especie;
import model.EspecieDAO;

/**
 *
 * @author maria
 */
public class EspecieTableModel extends GenericTableModel {
    
    public EspecieTableModel (List vDados){
        super(vDados, new String[]{"Especie"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Especie especie = (Especie)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return especie.getNome();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Especie especie = (Especie)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                especie.setNome((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          EspecieDAO.getInstance().update(especie);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    
}
