package go.Grupo.Matricula.dao;

import go.Grupo.Matricula.Modelo.Curso;
import java.util.List;

public interface CursoDao {
    public List<Curso>listar();
    public void guardar(Curso c);
    public void modificar(Curso c);
    public void borrar(Curso c);
    Curso listarUno(int idCurso);
}
