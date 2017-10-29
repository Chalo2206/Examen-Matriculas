package go.Grupo.Matricula.Modelo;

public class CursoMatricula {
    private int idMatricula;
    private String ciclo;
    private String calificacion;    
    private int curso;
    private String alumno;

    public CursoMatricula() {
        this.idMatricula = 0;
        this.ciclo = "";
        this.calificacion = "";        
        this.curso = 0;
        this.alumno = "";
    }

    public CursoMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public CursoMatricula(String alumno) {
        this.alumno = alumno;
    }

    public CursoMatricula(int idMatricula, String ciclo, String calificacion, int curso, String alumno) {
        this.idMatricula = idMatricula;
        this.ciclo = ciclo;
        this.calificacion = calificacion;
        this.curso = curso;
        this.alumno = alumno;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
}
