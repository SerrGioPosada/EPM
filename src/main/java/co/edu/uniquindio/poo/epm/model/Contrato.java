package co.edu.uniquindio.poo.epm.model;

public class Contrato {
    private String fechaEmision;
    private String cliente;
    private String servicio;
    private String total;
    private String estado;
    private String vencimiento;

    public Contrato(String fechaEmision, String cliente, String servicio,
                    String total, String estado, String vencimiento) {
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
        this.servicio = servicio;
        this.total = total;
        this.estado = estado;
        this.vencimiento = vencimiento;
    }

    public String getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(String fechaEmision) { this.fechaEmision = fechaEmision; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getServicio() { return servicio; }
    public void setServicio(String servicio) { this.servicio = servicio; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getVencimiento() { return vencimiento; }
    public void setVencimiento(String vencimiento) { this.vencimiento = vencimiento; }
}
