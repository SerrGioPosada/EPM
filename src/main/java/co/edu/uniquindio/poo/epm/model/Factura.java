package co.edu.uniquindio.poo.epm.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Factura {
    private final StringProperty fecha;
    private final StringProperty servicio;
    private final StringProperty periodo;
    private final StringProperty consumo;
    private final StringProperty valor;
    private final StringProperty estado;
    private final StringProperty fechaPago;

    public Factura(String fecha, String servicio, String periodo, String consumo, String valor, String estado, String fechaPago) {
        this.fecha = new SimpleStringProperty(fecha);
        this.servicio = new SimpleStringProperty(servicio);
        this.periodo = new SimpleStringProperty(periodo);
        this.consumo = new SimpleStringProperty(consumo);
        this.valor = new SimpleStringProperty(valor);
        this.estado = new SimpleStringProperty(estado);
        this.fechaPago = new SimpleStringProperty(fechaPago);
    }

    public String getFecha() { return fecha.get(); }
    public StringProperty fechaProperty() { return fecha; }
    public void setFecha(String value) { fecha.set(value); }

    public String getServicio() { return servicio.get(); }
    public StringProperty servicioProperty() { return servicio; }
    public void setServicio(String value) { servicio.set(value); }

    public String getPeriodo() { return periodo.get(); }
    public StringProperty periodoProperty() { return periodo; }
    public void setPeriodo(String value) { periodo.set(value); }

    public String getConsumo() { return consumo.get(); }
    public StringProperty consumoProperty() { return consumo; }
    public void setConsumo(String value) { consumo.set(value); }

    public String getValor() { return valor.get(); }
    public StringProperty valorProperty() { return valor; }
    public void setValor(String value) { valor.set(value); }

    public String getEstado() { return estado.get(); }
    public StringProperty estadoProperty() { return estado; }
    public void setEstado(String value) { estado.set(value); }

    public String getFechaPago() { return fechaPago.get(); }
    public StringProperty fechaPagoProperty() { return fechaPago; }
    public void setFechaPago(String value) { fechaPago.set(value); }
}
