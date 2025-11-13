package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MovimientoPresupuestal {
    private final StringProperty fecha;
    private final StringProperty tipo;
    private final StringProperty concepto;
    private final StringProperty monto;
    private final StringProperty saldo;
    private final StringProperty responsable;

    public MovimientoPresupuestal(String fecha, String tipo, String concepto, String monto, String saldo, String responsable) {
        this.fecha = new SimpleStringProperty(fecha);
        this.tipo = new SimpleStringProperty(tipo);
        this.concepto = new SimpleStringProperty(concepto);
        this.monto = new SimpleStringProperty(monto);
        this.saldo = new SimpleStringProperty(saldo);
        this.responsable = new SimpleStringProperty(responsable);
    }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getTipo() { return tipo.get(); }
    public StringProperty tipoProperty() { return tipo; }
    public void setTipo(String value) { tipo.set(value); }

    public String getConcepto() { return concepto.get(); }
    public StringProperty conceptoProperty() { return concepto; }
    public void setConcepto(String value) { concepto.set(value); }

    public String getMonto() { return monto.get(); }
    public StringProperty montoProperty() { return monto; }
    public void setMonto(String value) { monto.set(value); }

    public String getSaldo() { return saldo.get(); }
    public StringProperty saldoProperty() { return saldo; }
    public void setSaldo(String value) { saldo.set(value); }

    public String getResponsable() { return responsable.get(); }
    public StringProperty responsableProperty() { return responsable; }
    public void setResponsable(String value) { responsable.set(value); }
}
