package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empleado {
    private final StringProperty id;
    private final StringProperty nombre;
    private final StringProperty cedula;
    private final StringProperty cargo;
    private final StringProperty area;
    private final StringProperty salario;
    private final StringProperty desempeno;
    private final StringProperty estado;

    public Empleado(String id, String nombre, String cedula, String cargo, String area, String salario, String desempeno, String estado) {
        this.id = new SimpleStringProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.cedula = new SimpleStringProperty(cedula);
        this.cargo = new SimpleStringProperty(cargo);
        this.area = new SimpleStringProperty(area);
        this.salario = new SimpleStringProperty(salario);
        this.desempeno = new SimpleStringProperty(desempeno);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getId() { return id.get(); }
    public StringProperty idProperty() { return id; }
    public void setId(String value) { id.set(value); }

    public String getNombre() { return nombre.get(); }
    public StringProperty nombreProperty() { return nombre; }
    public void setNombre(String value) { nombre.set(value); }

    public String getCedula() { return cedula.get(); }
    public StringProperty cedulaProperty() { return cedula; }
    public void setCedula(String value) { cedula.set(value); }

    public String getCargo() { return cargo.get(); }
    public StringProperty cargoProperty() { return cargo; }
    public void setCargo(String value) { cargo.set(value); }

    public String getArea() { return area.get(); }
    public StringProperty areaProperty() { return area; }
    public void setArea(String value) { area.set(value); }

    public String getSalario() { return salario.get(); }
    public StringProperty salarioProperty() { return salario; }
    public void setSalario(String value) { salario.set(value); }

    public String getDesempeno() { return desempeno.get(); }
    public StringProperty desempenoProperty() { return desempeno; }
    public void setDesempeno(String value) { desempeno.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }
}
