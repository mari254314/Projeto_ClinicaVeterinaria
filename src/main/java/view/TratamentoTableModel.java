/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Animal;
import model.AnimalDAO;
import model.Especie;
import model.EspecieDAO;
import model.Tratamento;
import model.TratamentoDAO;

/**
 *
 * @author maria
 */
public class TratamentoTableModel extends GenericTableModel{
    
    public TratamentoTableModel (List vDados){
        super(vDados, new String[]{"Nome do Tratamento","Data de Início","Data de Fim","Animal"});
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
            case 3:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(rowIndex!=0){
        
        Tratamento tratamento = (Tratamento)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return tratamento.getNome();
            case 1:
                return tratamento.getDataIni();
            case 2:
                return tratamento.getDataFim();
            case 3:
                return tratamento.getAnimal();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }}return null;
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                tratamento.setNome((String)aValue);
                break;
            case 1:
                tratamento.setDataIni((String)aValue);
                break;
            case 2:
                tratamento.setDataFim((String)aValue);
                break;
            case 3:
               tratamento.setAnimal((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          TratamentoDAO.getInstance().update(tratamento);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }

}
