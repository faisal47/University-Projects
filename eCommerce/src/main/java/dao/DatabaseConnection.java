package dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nur Uddin
 */
public class DatabaseConnection {
    private PreparedStatement statement;
    private ResultSet res;
    private Connection conn;
    
    public DatabaseConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ecommerce", "root", "") ;
            System.out.println("database connected");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getResultSet(String query){
        
        try {
            statement = conn.prepareStatement(query);
            res = statement.executeQuery(query);
        } catch (Exception e) {
        }
        
        return res;
    }
    
    public boolean  doDatabaseExecution(String query){
        try {
            statement = conn.prepareStatement(query);
            return statement.execute(query);
        } catch (Exception e) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            String stackTrace = writer.toString();
            System.out.println(stackTrace);
        }
        return  false;
    }
}
