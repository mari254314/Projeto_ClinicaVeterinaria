/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Exame;
import model.ExameDAO;

/**
 *
 * @author maria
 */
public class ExameTableModel  extends GenericTableModel {
   
    public ExameTableModel (List vDados){
        super(vDados, new String[]{"Descrição do Exame"});
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
        Exame exame = (Exame)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return exame.getDescricao();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Exame exame = (Exame)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                exame.setDescricao((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          ExameDAO.getInstance().update(exame);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
}
