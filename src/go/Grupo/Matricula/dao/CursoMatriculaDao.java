package go.Grupo.Matricula.dao;

import go.Grupo.Matricula.Modelo.CursoMatricula;
import go.Grupo.Matricula.Modelo.Alumno;
import go.Grupo.Matricula.Modelo.Curso;
import java.util.List;

public interface CursoMatriculaDao {
    public List<CursoMatricula>listar(int idMatricula);
    public void guardar(CursoMatricula m);
    public void modificar(CursoMatricula m);
    public void borrar(CursoMatricula m);
    CursoMatricula listarUno(int idMatricula);
}
