package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PQR {
    private final StringProperty radicado;
    private final StringProperty fecha;
    private final StringProperty tipo;
    private final StringProperty servicio;
    private final StringProperty motivo;
    private final StringProperty estado;
    private final StringProperty responsable;
    private final StringProperty fechaRespuesta;

    public PQR(String radicado, String fecha, String tipo, String servicio, String motivo, String estado, String responsable) {
        this(radicado, fecha, tipo, servicio, motivo, estado, responsable, "Pendiente");
    }

    public PQR(String radicado, String fecha, String tipo, String servicio, String motivo, String estado, String responsable, String fechaRespuesta) {
        this.radicado = new SimpleStringProperty(radicado);
        this.fecha = new SimpleStringProperty(fecha);
        this.tipo = new SimpleStringProperty(tipo);
        this.servicio = new SimpleStringProperty(servicio);
        this.motivo = new SimpleStringProperty(motivo);
        this.estado = new SimpleStringProperty(estado);
        this.responsable = new SimpleStringProperty(responsable);
        this.fechaRespuesta = new SimpleStringProperty(fechaRespuesta);
    }

    public String getRadicado() { return radicado.get(); }
    public StringProperty radicadoProperty() { return radicado; }
    public void setRadicado(String value) { radicado.set(value); }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getServicio() { return servicio.get(); }
    public StringProperty servicioProperty() { return servicio; }
    public void setServicio(String value) { servicio.set(value); }

    public String getMotivo() { return motivo.get(); }
    public StringProperty motivoProperty() { return motivo; }
    public void setMotivo(String value) { motivo.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }

    public String getResponsable() { return responsable.get(); }
    public StringProperty responsableProperty() { return responsable; }
    public void setResponsable(String value) { responsable.set(value); }

    public String getFechaRespuesta() { return fechaRespuesta.get(); }
    public StringProperty fechaRespuestaProperty() { return fechaRespuesta; }
    public void setFechaRespuesta(String value) { fechaRespuesta.set(value); }
}
