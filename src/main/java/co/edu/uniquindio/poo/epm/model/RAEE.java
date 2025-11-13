package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RAEE {
    private final StringProperty id;
    private final StringProperty tipoEquipo;
    private final StringProperty cantidad;
    private final StringProperty ubicacion;
    private final StringProperty fechaRecepcion;
    private final StringProperty destino;
    private final StringProperty estado;

    public RAEE(String id, String tipoEquipo, String cantidad, String ubicacion, String fechaRecepcion, String destino, String estado) {
        this.id = new SimpleStringProperty(id);
        this.tipoEquipo = new SimpleStringProperty(tipoEquipo);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.ubicacion = new SimpleStringProperty(ubicacion);
        this.fechaRecepcion = new SimpleStringProperty(fechaRecepcion);
        this.destino = new SimpleStringProperty(destino);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getId() { return id.get(); }
    public StringProperty idProperty() { return id; }
    public void setId(String value) { id.set(value); }

    public String getTipoEquipo() { return tipoEquipo.get(); }
    public StringProperty tipoEquipoProperty() { return tipoEquipo; }
    public void setTipoEquipo(String value) { tipoEquipo.set(value); }

    public String getCantidad() { return cantidad.get(); }
    public StringProperty cantidadProperty() { return cantidad; }
    public void setCantidad(String value) { cantidad.set(value); }

    public String getUbicacion() { return ubicacion.get(); }
    public StringProperty ubicacionProperty() { return ubicacion; }
    public void setUbicacion(String value) { ubicacion.set(value); }

    public String getFechaRecepcion() { return fechaRecepcion.get(); }
    public StringProperty fechaRecepcionProperty() { return fechaRecepcion; }
    public void setFechaRecepcion(String value) { fechaRecepcion.set(value); }

    public String getDestino() { return destino.get(); }
    public StringProperty destinoProperty() { return destino; }
    public void setDestino(String value) { destino.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }
}
