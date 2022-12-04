/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Animal;
import model.AnimalDAO;
import model.ClienteDAO;
import model.Consulta;
import model.ConsultaDAO;
import model.VeterinarioDAO;

/**
 *
 * @author maria
 */
public class ConsultaTableModel extends GenericTableModel{
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
     public ConsultaTableModel (List vDados){
        super(vDados, new String[]{"Hora","Data","Cliente","Animal","Veterinário","Comentário"});
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
//            case 6:
//                return Boolean.class;
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta)vDados.get(rowIndex);
        Animal animal;
        
        switch (columnIndex) {
            case 0:
                return consulta.getHorario();
            case 1:
                return dateFormat.format(consulta.getData().getTime());
            case 2:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getId_animal());
                return ClienteDAO.getInstance().retrieveById(animal.getId_cliente()).getNome();
            case 3:
                animal = AnimalDAO.getInstance().retrieveById(consulta.getId_animal());
                return animal.getNome();
            case 4:
                return VeterinarioDAO.getInstance().retrieveById(consulta.getId_veterinario()).getNome();
            case 5:
                return consulta.getComentario();
//            case 6:
//                return consulta.isTerminou();
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta)vDados.get(rowIndex);
        
          switch (columnIndex) {
            case 0:
                consulta.setHorario((Integer)aValue);
            case 1:
                Calendar cal = Calendar.getInstance();
                try{
                    cal.setTime(dateFormat.parse((String)aValue));
                }catch (ParseException ex){
                    Logger.getLogger(ConsultaTableModel.class.getName()).log(Level.SEVERE, null, ex);
                }
                consulta.setData(cal);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                consulta.setComentario((String)aValue);
                break;
//            case 6:
//                consulta.setTerminou((Boolean)aValue);
//                break;    
            default:
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
          ConsultaDAO.getInstance().update(consulta);
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex){
        if ((columnIndex<2)||(columnIndex>4)){
            return true;
        }else{
            return false;
        }
    }    
}
