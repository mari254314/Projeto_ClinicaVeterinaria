package model;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/** @author Mariana **/
/** DAO Implementation for SQLite.**/

public abstract class DAO {

    public static final String DB = "jdbc:sqlite:ProjetoClinica.db";
    
    private static Connection con;
    
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Gera a conexão com o banco SQLite
    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DB);
                if (con != null) {
                    DatabaseMetaData meta = con.getMetaData();
                }
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
        }
        return con;
    }

    protected ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = (Statement) con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }

    protected int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = (Statement) con.createStatement();
            ResultSet rs = s.executeQuery("SELECT MAX(" + primaryKey + ") AS id FROM " + tableName);
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void terminar() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    // Create table SQLite
    protected final boolean createTable() {
        try {
            PreparedStatement stmt;
            // Table client:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS cliente( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        endereco VARCHAR, 
                                                        telefone VARCHAR, 
                                                        cep VARCHAR, 
                                                        email VARCHAR); 
                                                        """);
            executeUpdate(stmt);
            // Table animal:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS animal( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        idade INTEGER, 
                                                        sexo VARCHAR, 
                                                        id_especie INTEGER, 
                                                        id_cliente INTEGER,
                                                        FOREIGN KEY (id_especie) REFERENCES especie(id),
                                                        FOREIGN KEY (id_cliente) REFERENCES cliente(id)
                                                        ); 
                                                        """);
            executeUpdate(stmt);
            // Table species:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS especie( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR); 
                                                        """);
            executeUpdate(stmt);
            // Table vet:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS veterinario( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        email VARCHAR, 
                                                        telefone VARCHAR); 
                                                        """);
            executeUpdate(stmt);        
            // Table treatment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS tratamento( 
                                                        id INTEGER PRIMARY KEY, 
                                                        nome VARCHAR, 
                                                        dataFim TEXT, 
                                                        dataIni TEXT, 
                                                        animal VARCHAR); 
                                                        """);
            executeUpdate(stmt);
            // Table appointment:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS consulta( 
                                                        id INTEGER PRIMARY KEY, 
                                                        horario INTEGER, 
                                                        data DATE, 
                                                        comentario VARCHAR, 
                                                        id_veterinario INTEGER, 
                                                        id_animal VARCHAR, 
                                                        id_tratamento VARCHAR, 
                                                        obs VARCHAR,
                                                        FOREIGN KEY (id_veterinario) REFERENCES veterinario(id),
                                                        FOREIGN KEY (id_animal) REFERENCES animal(id),
                                                        FOREIGN KEY (id_tratamento) REFERENCES tratamento(id) 
                                                         ); 
                                                        """);
            executeUpdate(stmt);            
             // Table exam:
            stmt = DAO.getConnection().prepareStatement("""
                                                        CREATE TABLE IF NOT EXISTS exame( 
                                                        id INTEGER PRIMARY KEY, 
                                                        descricao VARCHAR, 
                                                        id_consulta INTEGER,
                                                        FOREIGN KEY (id_consulta) REFERENCES consulta(id)
                                                        ); 
                                                        """);
            executeUpdate(stmt);      
            // Default element for species:
            stmt = DAO.getConnection().prepareStatement("INSERT OR IGNORE INTO especie (id, nome) VALUES (1, 'Cachorro');");
            executeUpdate(stmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
