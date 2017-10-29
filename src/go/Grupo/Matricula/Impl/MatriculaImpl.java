package go.Grupo.Matricula.Impl;

import go.Grupo.Matricula.Modelo.Alumno;
import go.Grupo.Matricula.Modelo.Curso;
import go.Grupo.Matricula.Modelo.CursoMatricula;
import go.Grupo.Matricula.dao.CursoMatriculaDao;
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

public class MatriculaImpl implements CursoMatriculaDao {

    @Override
    public List<CursoMatricula> listar(int idMatricula) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            Connection conn = ConexionSingleton.getConnection();            
            ps = conn.prepareStatement("SELECT * FROM Curso c INNER JOIN CursoMatricula m ON c.idCurso = m.idCurso INNER JOIN Alumno a ON a.codigo = m.codigo WHERE a.codigo = ? GROUP BY c.denominacion");
            List<CursoMatricula> Matricula = new ArrayList<>();
            List<Curso> Curso = new ArrayList<>();
            ps.setInt(1, idMatricula);
            rs = ps.executeQuery();
            while(rs.next()){
                CursoMatricula matricula = new CursoMatricula(); 
                Curso curso = new Curso();
                curso.setDenominacion(rs.getString("Denominacion"));
                matricula.setCiclo(rs.getString("ciclo"));  
                matricula.setCalificacion(rs.getString("calificacion"));
                Matricula.add(matricula);
                Curso.add(curso);                
            }
            return Matricula;
        }catch(SQLException ex){
            Logger.getLogger(MatriculaImpl.class.getName()).log(Level.SEVERE,null,ex);
            return null;
        }
    }

    @Override
    public void guardar(CursoMatricula m) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO CursoMatricula VALUES (?,?,?,?,?)");
            ps.setInt(1, m.getIdMatricula());
            ps.setString(2, m.getCiclo());
            ps.setString(3, m.getCalificacion());
            ps.setObject(4, m.getCurso());
            ps.setObject(5, m.getAlumno());
            ps.executeUpdate();           
        }catch(SQLException ex){
            Logger.getLogger(MatriculaImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void modificar(CursoMatricula m) {
        try{
           Connection conn = ConexionSingleton.getConnection();
           PreparedStatement ps = conn.prepareStatement("UPDATE CursoMatricula SET ciclo = ?, calificacion = ?, idCurso = ?, codigo = ? WHERE idMatricula = ?");           
           ps.setString(1, m.getCiclo());
           ps.setString(2, m.getCalificacion());
           ps.setInt(3, m.getCurso());
           ps.setString(4, m.getAlumno());
           ps.setInt(5, m.getIdMatricula());
           ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(MatriculaImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    @Override
    public void borrar(CursoMatricula m) {
        try{
            Connection conn = ConexionSingleton.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE  FROM CursoMatricula  WHERE idMatricula = ?");
            ps.setInt(1, m.getIdMatricula());
            ps.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(MatriculaImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    @Override
    public CursoMatricula listarUno(int idMatricula) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Alumno a = null;
        Curso c = null;
        CursoMatricula m = null;
        try{
            Connection conn = ConexionSingleton.getConnection();
            ps = conn.prepareStatement("SELECT * FROM Curso c INNER JOIN CursoMatricula m ON c.idCurso = m.idCurso INNER JOIN Alumno a ON a.codigo = m.codigo WHERE a.codigo = ? GROUP BY c.denominacion");   
            ps.setInt(1, idMatricula);
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
        return m;   
    }   
}
