package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Version {
    private final StringProperty version;
    private final StringProperty fecha;
    private final StringProperty autor;
    private final StringProperty cambios;
    private final StringProperty estado;

    public Version(String version, String fecha, String autor, String cambios, String estado) {
        this.version = new SimpleStringProperty(version);
        this.fecha = new SimpleStringProperty(fecha);
        this.autor = new SimpleStringProperty(autor);
        this.cambios = new SimpleStringProperty(cambios);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getVersion() { return version.get(); }
    public StringProperty versionProperty() { return version; }
    public void setVersion(String value) { version.set(value); }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getAutor() { return autor.get(); }
    public StringProperty autorProperty() { return autor; }
    public void setAutor(String value) { autor.set(value); }

    public String getCambios() { return cambios.get(); }
    public StringProperty cambiosProperty() { return cambios; }
    public void setCambios(String value) { cambios.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }
}
