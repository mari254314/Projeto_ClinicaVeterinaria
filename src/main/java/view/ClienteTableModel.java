/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Cliente;
import model.ClienteDAO;

/**
 *
 * @author maria
 */
public class ClienteTableModel extends GenericTableModel {
    
    public ClienteTableModel (List vDados){
        super(vDados, new String[]{"Nome","Endereço","Telefone","Cep","Email"});
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
            case 4:
                return String.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente client = (Cliente)vDados.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return client.getNome();
            case 1:
                return client.getEndereco();
            case 2:
                return client.getTelefone();
            case 3:
                return client.getCep();
            case 4:
                return client.getEmail();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente client = (Cliente)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                client.setNome((String)aValue);
                break;
            case 1:
                client.setEndereco((String)aValue);
                break;
            case 2:
                client.setTelefone((String)aValue);
                break;
            case 3:
                client.setCep((String)aValue);
                break;
            case 4:
                client.setEmail((String)aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          ClienteDAO.getInstance().update(client);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return true;
    }
    
    
}
