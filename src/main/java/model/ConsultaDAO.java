package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static model.DAO.getConnection;

/** @author Mariana **/

  public class ConsultaDAO extends DAO {
    private static ConsultaDAO instance;

    private ConsultaDAO() {
        getConnection();
        createTable();
    }

    // Singleton
    public static ConsultaDAO getInstance() {
        return (instance==null?(instance = new ConsultaDAO()):instance);
    }

// CRUD    
    public Consulta create(int horario, Calendar data, String comentario, int id_veterinario, int id_animal, int id_tratamento, boolean terminou) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (horario, data, comentario, id_veterinario, id_animal, id_tratamento, terminou) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1, horario);
            stmt.setDate(2, new Date(data.getTimeInMillis()));
            stmt.setString(3, comentario);
            stmt.setInt(4, id_veterinario);
            stmt.setInt(5, id_animal);
            stmt.setInt(6, id_tratamento);
            stmt.setInt(7, (terminou?1:0));
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.retrieveById(lastId("consulta","id"));
    }
    
    private Consulta buildObject(ResultSet rs) {
        Consulta consulta = null;
        try {
            Calendar dt = Calendar.getInstance();
            dt.setTime(rs.getDate("data"));
                    
            consulta = new Consulta(rs.getInt("id"), rs.getInt("horario"), dt , rs.getString("comentario"), rs.getInt("id_veterinario"), rs.getInt("id_animal"), rs.getInt("id_tratamento"), rs.getBoolean("terminou"));
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consulta;
    }

    // Generic Retriever
    public List retrieve(String query) {
        List<Consulta> consultas = new ArrayList();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                consultas.add(buildObject(rs));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return consultas;
    }
    
    // RetrieveAll
    public List retrieveAll() {
        return this.retrieve("SELECT * FROM consulta ORDER BY data, horario");
    }
    
    // RetrieveLast
    public List retrieveLast(){
        return this.retrieve("SELECT * FROM consulta WHERE id = " + lastId("consulta","id"));
    }

    // RetrieveById
    public Consulta retrieveById(int id) {
        List<Consulta> consultas = this.retrieve("SELECT * FROM consulta WHERE id = " + id);
        return (consultas.isEmpty()?null:consultas.get(0));
    }

    // RetrieveBySimilarName
    public List retrieveBySimilarName(String nome) {
        return this.retrieve("SELECT * FROM consulta WHERE nome LIKE '%" + nome + "%'");
    }    
        
    // Updade
    public void update(Consulta consulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET horario=?, data=?, comentario=?, id_veterinario=?, id_animal=?, id_tratamento=?, terminou=? WHERE id=?");
            stmt.setInt(1, consulta.getHorario());
            stmt.setDate(2, new Date(consulta.getData().getTimeInMillis()));
            stmt.setString(3, consulta.getComentario());
            stmt.setInt(4, consulta.getId_veterinario());
            stmt.setInt(5, consulta.getId_animal());            
            stmt.setInt(6, consulta.getId_tratamento());
            stmt.setInt(7, (consulta.isTerminou()?1:0));
            stmt.setInt(8, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
        // Delete   
    public void delete(Consulta consulta) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement("DELETE FROM consulta WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
  }