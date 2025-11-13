package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProyectoIDi {
    private final StringProperty codigo;
    private final StringProperty nombre;
    private final StringProperty tipo;
    private final StringProperty resultado;
    private final StringProperty objetivo;
    private final StringProperty impacto;
    private final StringProperty estado;

    public ProyectoIDi(String codigo, String nombre, String tipo, String resultado, String objetivo, String impacto, String estado) {
        this.codigo = new SimpleStringProperty(codigo);
        this.nombre = new SimpleStringProperty(nombre);
        this.tipo = new SimpleStringProperty(tipo);
        this.resultado = new SimpleStringProperty(resultado);
        this.objetivo = new SimpleStringProperty(objetivo);
        this.impacto = new SimpleStringProperty(impacto);
        this.estado = new SimpleStringProperty(estado);
    }

    public String getCodigo() { return codigo.get(); }
    public StringProperty codigoProperty() { return codigo; }
    public void setCodigo(String value) { codigo.set(value); }

    public String getNombre() { return nombre.get(); }
    public StringProperty nombreProperty() { return nombre; }
    public void setNombre(String value) { nombre.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getResultado() { return resultado.get(); }
    public StringProperty resultadoProperty() { return resultado; }
    public void setResultado(String value) { resultado.set(value); }

    public String getObjetivo() { return objetivo.get(); }
    public StringProperty objetivoProperty() { return objetivo; }
    public void setObjetivo(String value) { objetivo.set(value); }

    public String getImpacto() { return impacto.get(); }
    public StringProperty impactoProperty() { return impacto; }
    public void setImpacto(String value) { impacto.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }
}
