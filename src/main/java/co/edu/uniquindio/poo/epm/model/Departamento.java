package co.edu.uniquindio.poo.epm.model;

public class Departamento {
    private String nombre;
    private String numEmpleados;
    private String vacantesAbiertas;
    private String rotacion;
    private String desempeno;
    private String horasCapacitacion;

    public Departamento(String nombre, String numEmpleados, String vacantesAbiertas,
                        String rotacion, String desempeno, String horasCapacitacion) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
        this.vacantesAbiertas = vacantesAbiertas;
        this.rotacion = rotacion;
        this.desempeno = desempeno;
        this.horasCapacitacion = horasCapacitacion;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getNumEmpleados() { return numEmpleados; }
    public void setNumEmpleados(String numEmpleados) { this.numEmpleados = numEmpleados; }

    public String getVacantesAbiertas() { return vacantesAbiertas; }
    public void setVacantesAbiertas(String vacantesAbiertas) { this.vacantesAbiertas = vacantesAbiertas; }

    public String getRotacion() { return rotacion; }
    public void setRotacion(String rotacion) { this.rotacion = rotacion; }

    public String getDesempeno() { return desempeno; }
    public void setDesempeno(String desempeno) { this.desempeno = desempeno; }

    public String getHorasCapacitacion() { return horasCapacitacion; }
    public void setHorasCapacitacion(String horasCapacitacion) { this.horasCapacitacion = horasCapacitacion; }
}
