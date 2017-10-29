package go.Grupo.Matricula.Impl;

import go.Grupo.Matricula.Modelo.Curso;
import go.Grupo.Matricula.dao.CursoDao;
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

public class CursoImpl implements CursoDao {

    @Override
    public List<Curso> listar() {
        try{
            Connection conn = ConexionSingleton.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Curso");
            List<Curso> Curso = new ArrayList<>();
            while(rs.next()){
                Curso curso = new Curso();                
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setDenominacion(rs.getString("denominacion"));               
                Curso.add(curso);
            }
            return Curso;
        }catch(SQLException ex){
            Logger.getLogger(CursoImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void guardar(Curso c) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Curso VALUES (?,?)");
            ps.setInt(1, c.getIdCurso());
            ps.setString(2, c.getDenominacion());            
            ps.executeUpdate();           
        }catch(SQLException ex){
            Logger.getLogger(CursoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void modificar(Curso c) {
        try{
           Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("UPDATE Curso SET denominacion = ? WHERE idCurso = ?");           
           ps.setString(1, c.getDenominacion());
           ps.setInt(2, c.getIdCurso());           
           ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(CursoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void borrar(Curso c) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE m, c FROM CursoMatricula m LEFT JOIN Curso c ON m.idCurso = c.idCurso WHERE m.idCurso = ?");
            ps.setInt(1, c.getIdCurso());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(CursoImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public Curso listarUno(int idCurso) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Curso c = null;
        try{
            Connection conn = ConexionSingleton.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Curso WHERE idCurso = ?");   
            ps.setInt(1, idCurso);
            rs = ps.executeQuery();
            while(rs.next()){                       
                c.setIdCurso(rs.getInt("idCurso"));
                c.setDenominacion(rs.getString("denominacion"));
                
            }            
        }catch(SQLException ex){
            Logger.getLogger(CursoImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
        return c;   
    }    
}
