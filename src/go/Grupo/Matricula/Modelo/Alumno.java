package go.Grupo.Matricula.Modelo;

public class Alumno {
    private String codigo;
    private String nombres;
    private String apPaterno;
    private String apMaterno;    

    public Alumno() {
        this.codigo = "";
        this.nombres = "";
        this.apPaterno = "";
        this.apMaterno = "";
    }

    public Alumno(String codigo) {
        this.codigo = codigo;
    }

    public Alumno(String codigo, String nombres, String apPaterno, String apMaterno) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
}
