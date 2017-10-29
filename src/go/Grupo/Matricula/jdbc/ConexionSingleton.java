package go.Grupo.Matricula.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSingleton {
    private static Connection conn = null;
    
    private ConexionSingleton(){}
    
    public static Connection getConnection(){
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                        
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Matriculas", "usuario", "Chalo1122");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }
}
