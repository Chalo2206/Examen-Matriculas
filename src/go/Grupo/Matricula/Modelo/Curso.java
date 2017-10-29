package go.Grupo.Matricula.Modelo;

import go.Grupo.Matricula.jdbc.ConexionSingleton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;

public class Curso {
    private int idCurso;
    private String denominacion;   

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    public Curso() {
        
    }

    public Curso(int idCurso, String Denominacion) {
        this.idCurso = idCurso;
        this.denominacion = Denominacion;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String Denominacion) {
        this.denominacion = Denominacion;
    }
    
    public void MostarCliente(JComboBox<Curso> cboCurso) {
         String sql="SELECT * FROM Curso";
        try {
            Connection conn = ConexionSingleton.getConnection();            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                cboCurso.addItem(
                        new Curso(
                                rs.getInt("idCurso"),
                                rs.getString("denominacion")
                        )                   
                );
            }
        } catch (Exception e) {
        }
    }
    public String toString(){
        return denominacion;
    }
            
}
