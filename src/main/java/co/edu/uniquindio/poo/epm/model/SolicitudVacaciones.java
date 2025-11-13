package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SolicitudVacaciones {
    private final StringProperty fechaSolicitud;
    private final StringProperty inicio;
    private final StringProperty fin;
    private final StringProperty dias;
    private final StringProperty tipo;
    private final StringProperty estado;
    private final StringProperty aprobadoPor;

    public SolicitudVacaciones(String fechaSolicitud, String inicio, String fin, String dias, String tipo, String estado, String aprobadoPor) {
        this.fechaSolicitud = new SimpleStringProperty(fechaSolicitud);
        this.inicio = new SimpleStringProperty(inicio);
        this.fin = new SimpleStringProperty(fin);
        this.dias = new SimpleStringProperty(dias);
        this.tipo = new SimpleStringProperty(tipo);
        this.estado = new SimpleStringProperty(estado);
        this.aprobadoPor = new SimpleStringProperty(aprobadoPor);
    }

    public String getFechaSolicitud() { return fechaSolicitud.get(); }
    public StringProperty fechaSolicitudProperty() { return fechaSolicitud; }
    public void setFechaSolicitud(String value) { fechaSolicitud.set(value); }

    public String getInicio() { return inicio.get(); }
    public StringProperty inicioProperty() { return inicio; }
    public void setInicio(String value) { inicio.set(value); }

    public String getFin() { return fin.get(); }
    public StringProperty finProperty() { return fin; }
    public void setFin(String value) { fin.set(value); }

    public String getDias() { return dias.get(); }
    public StringProperty diasProperty() { return dias; }
    public void setDias(String value) { dias.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }

    public String getAprobadoPor() { return aprobadoPor.get(); }
    public StringProperty aprobadoPorProperty() { return aprobadoPor; }
    public void setAprobadoPor(String value) { aprobadoPor.set(value); }
}
