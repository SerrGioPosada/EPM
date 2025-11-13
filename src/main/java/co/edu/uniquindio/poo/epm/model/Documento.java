package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Documento {
    private final StringProperty codigo;
    private final StringProperty titulo;
    private final StringProperty tipo;
    private final StringProperty area;
    private final StringProperty version;
    private final StringProperty fecha;
    private final StringProperty autor;

    public Documento(String codigo, String titulo, String tipo, String area, String version, String fecha, String autor) {
        this.codigo = new SimpleStringProperty(codigo);
        this.titulo = new SimpleStringProperty(titulo);
        this.tipo = new SimpleStringProperty(tipo);
        this.area = new SimpleStringProperty(area);
        this.version = new SimpleStringProperty(version);
        this.fecha = new SimpleStringProperty(fecha);
        this.autor = new SimpleStringProperty(autor);
    }

    public String getCodigo() { return codigo.get(); }
    public StringProperty codigoProperty() { return codigo; }
    public void setCodigo(String value) { codigo.set(value); }

    public String getTitulo() { return titulo.get(); }
    public StringProperty tituloProperty() { return titulo; }
    public void setTitulo(String value) { titulo.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getArea() { return area.get(); }
    public StringProperty areaProperty() { return area; }
    public void setArea(String value) { area.set(value); }

    public String getVersion() { return version.get(); }
    public StringProperty versionProperty() { return version; }
    public void setVersion(String value) { version.set(value); }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getAutor() { return autor.get(); }
    public StringProperty autorProperty() { return autor; }
    public void setAutor(String value) { autor.set(value); }
}
