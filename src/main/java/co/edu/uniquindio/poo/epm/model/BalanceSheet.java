package co.edu.uniquindio.poo.epm.model;

public class BalanceSheet {
    private String cuenta;
    private String categoria;
    private String saldoAnterior;
    private String movimientos;
    private String saldoActual;

    public BalanceSheet(String cuenta, String categoria, String saldoAnterior,
                        String movimientos, String saldoActual) {
        this.cuenta = cuenta;
        this.categoria = categoria;
        this.saldoAnterior = saldoAnterior;
        this.movimientos = movimientos;
        this.saldoActual = saldoActual;
    }

    public String getCuenta() { return cuenta; }
    public void setCuenta(String cuenta) { this.cuenta = cuenta; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getSaldoAnterior() { return saldoAnterior; }
    public void setSaldoAnterior(String saldoAnterior) { this.saldoAnterior = saldoAnterior; }

    public String getMovimientos() { return movimientos; }
    public void setMovimientos(String movimientos) { this.movimientos = movimientos; }

    public String getSaldoActual() { return saldoActual; }
    public void setSaldoActual(String saldoActual) { this.saldoActual = saldoActual; }
}
