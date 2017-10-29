package go.Grupo.Matricula.dao;

import go.Grupo.Matricula.Modelo.Alumno;
import java.util.List;

public interface AlumnoDao {
    public List<Alumno>listar();
    public void guardar(Alumno a);
    public void modificar(Alumno a);
    public void borrar(Alumno a);
    Alumno ListaUno(String codigo);
}
