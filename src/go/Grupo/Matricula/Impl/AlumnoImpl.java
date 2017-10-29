package go.Grupo.Matricula.Impl;

import go.Grupo.Matricula.Modelo.Alumno;
import go.Grupo.Matricula.Modelo.Curso;
import go.Grupo.Matricula.Modelo.CursoMatricula;
import go.Grupo.Matricula.dao.AlumnoDao;
import go.Grupo.Matricula.jdbc.ConexionSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoImpl implements AlumnoDao{

    @Override
    public List<Alumno> listar() {
        try{
            Connection conn = ConexionSingleton.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Alumno");
            List<Alumno> Alumno = new ArrayList<>();
            while(rs.next()){
                Alumno alumno = new Alumno();                
                alumno.setCodigo(rs.getString("codigo"));
                alumno.setNombres(rs.getString("nombre"));
                alumno.setApPaterno(rs.getString("apPaterno"));
                alumno.setApMaterno(rs.getString("apMaterno"));
                Alumno.add(alumno);
            }
            return Alumno;
        }catch(SQLException ex){
            Logger.getLogger(AlumnoImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void guardar(Alumno a) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Alumno VALUES (?,?,?,?)");
            ps.setString(1, a.getCodigo());
            ps.setString(2, a.getNombres());
            ps.setString(3, a.getApPaterno());
            ps.setString(4, a.getApMaterno());
            ps.executeUpdate();           
        }catch(SQLException ex){
            Logger.getLogger(AlumnoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void modificar(Alumno a) {
        try{
           Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("UPDATE Alumno SET nombre = ?, apPaterno = ?, apMaterno = ? WHERE codigo = ?");           
           ps.setString(1, a.getNombres());
           ps.setString(2, a.getApPaterno());
           ps.setString(3, a.getApMaterno());
           ps.setString(4, a.getCodigo());
           ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AlumnoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void borrar(Alumno a) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE c, a FROM CursoMatricula c LEFT JOIN Alumno a ON c.codigo = a.codigo WHERE c.codigo = ?");
            ps.setString(1, a.getCodigo());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(AlumnoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public Alumno ListaUno(String codigo) {    
        PreparedStatement ps = null;
        ResultSet rs = null;
        Alumno a = null;
        Curso c = null;
        CursoMatricula m = null;
        try{
            Connection conn = ConexionSingleton.getConnection();
            ps = conn.prepareStatement("SELECT c.denominacion, m.ciclo, m.calificacion FROM Curso c INNER JOIN CursoMatricula m ON c.idCurso = m.idCurso INNER JOIN Alumno a ON a.codigo = m.codigo WHERE m.codigo = ? GROUP BY c.denominacion;");   
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){                       
                c.setDenominacion(rs.getString("denominacion"));
                m.setCiclo(rs.getString("ciclo"));
                m.setCalificacion(rs.getString("calificacion"));
            }            
        }catch(SQLException ex){
            Logger.getLogger(AlumnoImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
        return a;   
    }
}