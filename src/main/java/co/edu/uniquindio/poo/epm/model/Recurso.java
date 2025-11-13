package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recurso {
    private final StringProperty tipoRecurso;
    private final StringProperty recurso;
    private final StringProperty cantidadHoras;
    private final StringProperty costoEstimado;
    private final StringProperty estado;
    private final StringProperty fechaAsignacion;

    public Recurso(String tipoRecurso, String recurso, String cantidadHoras, String costoEstimado, String estado, String fechaAsignacion) {
        this.tipoRecurso = new SimpleStringProperty(tipoRecurso);
        this.recurso = new SimpleStringProperty(recurso);
        this.cantidadHoras = new SimpleStringProperty(cantidadHoras);
        this.costoEstimado = new SimpleStringProperty(costoEstimado);
        this.estado = new SimpleStringProperty(estado);
        this.fechaAsignacion = new SimpleStringProperty(fechaAsignacion);
    }

    public String getTipoRecurso() { return tipoRecurso.get(); }
    public StringProperty tipoRecursoProperty() { return tipoRecurso; }
    public void setTipoRecurso(String value) { tipoRecurso.set(value); }

    public String getRecurso() { return recurso.get(); }
    public StringProperty recursoProperty() { return recurso; }
    public void setRecurso(String value) { recurso.set(value); }

    public String getCantidadHoras() { return cantidadHoras.get(); }
    public StringProperty cantidadHorasProperty() { return cantidadHoras; }
    public void setCantidadHoras(String value) { cantidadHoras.set(value); }

    public String getCostoEstimado() { return costoEstimado.get(); }
    public StringProperty costoEstimadoProperty() { return costoEstimado; }
    public void setCostoEstimado(String value) { costoEstimado.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }

    public String getFechaAsignacion() { return fechaAsignacion.get(); }
    public StringProperty fechaAsignacionProperty() { return fechaAsignacion; }
    public void setFechaAsignacion(String value) { fechaAsignacion.set(value); }
}
