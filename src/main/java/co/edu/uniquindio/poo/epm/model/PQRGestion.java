package co.edu.uniquindio.poo.epm.model;

public class PQRGestion {
    private String radicado;
    private String fecha;
    private String tipo;
    private String cliente;
    private String asunto;
    private String estado;
    private String responsable;

    public PQRGestion(String radicado, String fecha, String tipo, String cliente,
                      String asunto, String estado, String responsable) {
        this.radicado = radicado;
        this.fecha = fecha;
        this.tipo = tipo;
        this.cliente = cliente;
        this.asunto = asunto;
        this.estado = estado;
        this.responsable = responsable;
    }

    public String getRadicado() { return radicado; }
    public void setRadicado(String radicado) { this.radicado = radicado; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getAsunto() { return asunto; }
    public void setAsunto(String asunto) { this.asunto = asunto; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getResponsable() { return responsable; }
    public void setResponsable(String responsable) { this.responsable = responsable; }
}
