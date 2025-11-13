package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProyectoSocial {
    private final StringProperty codigo;
    private final StringProperty nombre;
    private final StringProperty comunidad;
    private final StringProperty beneficiarios;
    private final StringProperty inversion;
    private final StringProperty fechaInicio;
    private final StringProperty estado;

    public ProyectoSocial(String codigo, String nombre, String comunidad, String beneficiarios, String inversion, String fechaInicio, String estado) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.comunidad = new SimpleStringProperty(comunidad);
        this.beneficiarios = new SimpleStringProperty(beneficiarios);
        this.inversion = new SimpleStringProperty(inversion);
        this.fechaInicio = new SimpleStringProperty(fechaInicio);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getCodigo() { return codigo.get(); }
    public StringProperty codigoProperty() { return codigo; }
    public void setCodigo(String value) { codigo.set(value); }

    public String getNombre() { return nombre.get(); }
    public StringProperty nombreProperty() { return nombre; }
    public void setNombre(String value) { nombre.set(value); }

    public String getComunidad() { return comunidad.get(); }
    public StringProperty comunidadProperty() { return comunidad; }
    public void setComunidad(String value) { comunidad.set(value); }

    public String getBeneficiarios() { return beneficiarios.get(); }
    public StringProperty beneficiariosProperty() { return beneficiarios; }
    public void setBeneficiarios(String value) { beneficiarios.set(value); }

    public String getInversion() { return inversion.get(); }
    public StringProperty inversionProperty() { return inversion; }
    public void setInversion(String value) { inversion.set(value); }

    public String getFechaInicio() { return fechaInicio.get(); }
    public StringProperty fechaInicioProperty() { return fechaInicio; }
    public void setFechaInicio(String value) { fechaInicio.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }
}
