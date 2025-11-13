package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegistroMantenimiento {
    private final StringProperty orden;
    private final StringProperty fecha;
    private final StringProperty tipo;
    private final StringProperty descripcion;
    private final StringProperty responsable;
    private final StringProperty estado;
    private final StringProperty costo;

    public RegistroMantenimiento(String orden, String fecha, String tipo, String descripcion, String responsable, String estado, String costo) {
        this.orden = new SimpleStringProperty(orden);
        this.fecha = new SimpleStringProperty(fecha);
        this.tipo = new SimpleStringProperty(tipo);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.responsable = new SimpleStringProperty(responsable);
        this.estado = new SimpleStringProperty(estado);
        this.costo = new SimpleStringProperty(costo);
    }

    public String getOrden() { return orden.get(); }
    public StringProperty ordenProperty() { return orden; }
    public void setOrden(String value) { orden.set(value); }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getDescripcion() { return descripcion.get(); }
    public StringProperty descripcionProperty() { return descripcion; }
    public void setDescripcion(String value) { descripcion.set(value); }

    public String getResponsable() { return responsable.get(); }
    public StringProperty responsableProperty() { return responsable; }
    public void setResponsable(String value) { responsable.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }

    public String getCosto() { return costo.get(); }
    public StringProperty costoProperty() { return costo; }
    public void setCosto(String value) { costo.set(value); }
}
